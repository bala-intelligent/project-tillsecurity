package com.niit.foodcart.controller;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.foodcart.model.Foodproducts;
import com.niit.foodcart.service.impl.FoodproductsService;

@Controller
public class FoodproductsController {
	@Autowired
	 private FoodproductsService foodproductsService;
	//private ServletContext servletContext;
	

//    public void setServletContext(ServletContext servletContext) {
//		this.servletContext = servletContext;
//	}
		@RequestMapping("admin/frontcrud")
		public String setupForm(Map<String, Object>map){
			Foodproducts foodproducts = new Foodproducts();
			map.put("foodproducts", foodproducts);
			map.put("foodproductsList", foodproductsService.getAllFoodproducts());
			return "frontcrud";
		}
		@RequestMapping(value={"viewall.do","edit/viewall.do"},method =RequestMethod.POST)
		public String doActions( @ModelAttribute @Valid Foodproducts foodproducts,BindingResult result,@RequestParam String action,Map<String, Object>map){
			
			if(result.hasErrors())
			{
				System.out.println(result);
				return "frontcrud";
			}
			
			Foodproducts foodproductsdelivery = new Foodproducts();
			
			switch(action.toLowerCase()){
			case "add":
				MultipartFile file=foodproducts.getImage();
				
				foodproductsService.add(foodproducts);
				
				if(!file.isEmpty())
			{
					try
					{
						String rootPath ="C:/Program Files/Apache Software Foundation/apache-tomcat-9.0.0.M9";
						System.out.println(rootPath);
						File dir = new File(rootPath + File.separator + "images");
						if (!dir.exists())
							dir.mkdirs();
						//create the file on server
					File serverFile =new File(dir + File.separator + foodproducts.getImagename() + ".jpg");
					System.out.println(serverFile);
					file.transferTo(serverFile);
					return "redirect:/frontcrud";
					}
				catch(Exception e)
					{
						 return "You failed to upload " + e.getMessage();
				}
			}
				
				foodproductsdelivery=foodproducts; 
	
				break;
			case "edit":
				foodproductsService.edit(foodproducts);
				foodproductsdelivery=foodproducts;
				break;
			case "delete":
				foodproductsService.delete(foodproducts.getProductId());
				foodproductsdelivery=new Foodproducts();
				break;
			case "search":	
			Foodproducts searchedFoodproducts=	foodproductsService.getFoodproducts(foodproducts.getProductId());
				foodproductsdelivery=searchedFoodproducts!=null ? searchedFoodproducts:new Foodproducts();
				break;
				}
			map.put("foodproducts", foodproductsdelivery);
			map.put("foodproductsList", foodproductsService.getAllFoodproducts());
			return "viewall";
			
			
}
}

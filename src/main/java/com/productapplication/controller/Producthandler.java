package com.productapplication.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.productapplication.dao.ProductDao;
import com.productapplication.model.AdminUser;
import com.productapplication.model.ProductEntity;

@Controller
public class Producthandler {
	

	@Autowired
	ProductDao productDao;
	
		
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String login(Model model) {
		
		model.addAttribute("settitle", "Login Form");
		return "login";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public String register(Model model) {
		
		model.addAttribute("settitle", "SignUp Form");
		return "register";
	}
	
	@RequestMapping(value = "/user-login",method = RequestMethod.POST)
	public RedirectView validateUser(@ModelAttribute("adminUser") AdminUser adminUser,Model model,HttpServletRequest request) {
		
		RedirectView redirectView=new RedirectView();
		
		AdminUser exiUser = productDao.validateUser(adminUser.getUname(),adminUser.getUpassword());
		
		if (exiUser==null) {
			redirectView.setUrl(request.getContextPath()+"/");
		}else {
			redirectView.setUrl(request.getContextPath()+"/index");
		}
		
		return redirectView;
	}
	
	
	@RequestMapping(value = "/user-register",method = RequestMethod.POST)
	public RedirectView registerUser(@ModelAttribute("adminUser") AdminUser adminUser,Model model,HttpServletRequest request) {
		
		 AdminUser userExits = productDao.checkUserExits(adminUser.getUname());
		 
		 RedirectView redirectView=new RedirectView();
		
		if (userExits==null) {
			productDao.registerUser(adminUser);
			redirectView.setUrl(request.getContextPath()+"/");
		}else {	
			System.out.println("User Already Exits....");
			redirectView.setUrl(request.getContextPath()+"/register");
		}
		return redirectView;
	}

	
	@RequestMapping("/index")
	public String home(Model model) {
		List<ProductEntity> allProduct = productDao.getAllProduct();
		
		model.addAttribute("products", allProduct);
		return "index";
	}
	
	
	
	@RequestMapping(path = "/addproduct",method = RequestMethod.GET)
	public String addProduct(Model model) {
		
		model.addAttribute("settitle", "add product");
		return "add_product_from";
	}

	
	@RequestMapping(path = "add-product-data",method = RequestMethod.POST)
	public RedirectView addProductDetails(@ModelAttribute("productEntity") ProductEntity productEntity,Model model,HttpServletRequest request) {
		
		productDao.addProduct(productEntity);
		
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/index");
		
		return redirectView;
	}
	
	
	@RequestMapping(path = "/delete/{id}",method = RequestMethod.GET)
	public RedirectView deleteProduct(@PathVariable("id") int id,HttpServletRequest request) {
		
		productDao.deleteProductDetails(id);
		
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/index");
		
		return redirectView;
	}
	
	
	@RequestMapping(path = "/update/{id}",method = RequestMethod.GET)
	public String updateProduct(@PathVariable("id") int id,Model model,HttpServletRequest request) {
		
		ProductEntity oneProductDetails = productDao.getOneProductDetails(id);
		model.addAttribute("product", oneProductDetails);
		
		return "update_product_form";
	}
	
	
	@RequestMapping(path = "update-product-data",method = RequestMethod.POST)
	public RedirectView updateProductDetails(@ModelAttribute("productEntity") ProductEntity productEntity,Model model,HttpServletRequest request) {
		
		productDao.updateProductDetails(productEntity);
		
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/index");
		
		return redirectView;
	}
	
	
	
}

package com.org.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.SellerDao;
import com.org.dto.Seller;

@Controller
public class SellerController {
	
	@Autowired 
	private SellerDao sellerDao;
	
	@PostMapping("/register_seller")
	public ModelAndView registerSeller(@ModelAttribute Seller seller) {
		ModelAndView mav= new ModelAndView("seller/seller_login.jsp");
		sellerDao.insertAndUpdateSeller(seller);
		
		return mav;
		
	}
	
	@PostMapping("/login_seller")
	public ModelAndView loginSeller(@RequestParam String email,@RequestParam String password, HttpSession session) {
		Seller seller=sellerDao.fetchSellerByEmailAndPassword(email, password);
		
		if(seller != null) {
		
		  ModelAndView mav= new ModelAndView("seller/seller_homepage.jsp");
		  session.setAttribute("sellerId" , seller.getId());
		  return mav;
		}
		
		ModelAndView mav= new ModelAndView("seller/seller_login.jsp");
		mav.addObject("fail", "Invalid Credentials");
		return mav;
		
	}
	@GetMapping("/logout_seller")
	public ModelAndView logoutSeller(HttpSession session ) {
		if(session!=null) {
			session.invalidate();
			ModelAndView mav= new ModelAndView("seller/seller_login.jsp");
			return mav;
		}
		return null;
		
	}
	

}

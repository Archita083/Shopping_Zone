package com.org.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.ItemDao;
import com.org.dao.ProductDao;
import com.org.dao.UserDao;
import com.org.dto.Item;
import com.org.dto.Product;
import com.org.dto.User;

@Controller
public class ItemController {
	
	@Autowired
	 ProductDao productDao;
	
	@Autowired
	 ItemDao itemDao;
	
	@Autowired
	 UserDao userDao;
	
	@GetMapping("/add_item")
	public ModelAndView addItem(@RequestParam int productId, HttpSession session) {
		
	Product product= productDao.fetchProductById(productId);
	
	Item item=new Item();
	
	item.setName(product.getName());
	item.setPrice(product.getPrice());
	item.setCategory(product.getCategory());
	item.setDescription(product.getDescription());
	item.setStocksleft(product.getStockleft());
	//item.setProductId(product.getId());

	int userId=(int) session.getAttribute("userId");
	
	User user=userDao.fetchUserById(userId);
	
	List<Item> items = user.getItems();
	
	items.add(item);
	
	item.setUser(user);
	user.setItems(items);
	
	itemDao.addAndUpdateItem(item);
	
	ModelAndView mav=new ModelAndView("user/user_homepage.jsp");
	
	mav.addObject("success", "Product Added To Cart successfully");
	
	return mav;
		
	}
	
	@GetMapping("/remove_item")
	public ModelAndView removeItem(@RequestParam int itemId) {
		itemDao.removeItemById(itemId);
		ModelAndView mav=new ModelAndView("user/view_cart.jsp");
		
		return mav;
	}
	

}

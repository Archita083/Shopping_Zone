package com.org.dao;


import com.org.dto.Seller;

public interface SellerDao {

	void insertAndUpdateSeller(Seller seller);
	Seller fetchSellerByEmailAndPassword(String email, String password);
	Seller fetchSellerById(int id);
}

package com.org.dao;

import java.util.List;

import com.org.dto.Product;

public interface ProductDao {
	
	void addAndUpdateProduct(Product product);
	Product fetchProductById(int id);
	List<Product> fetchAllProduct();
	void deleteProductById(int id);

}

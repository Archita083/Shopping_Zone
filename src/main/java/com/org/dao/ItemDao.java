package com.org.dao;

import java.util.List;

import com.org.dto.Item;


public interface ItemDao {

	void addAndUpdateItem(Item item);
	
	Item fetchItemById(int id);
	List<Item> fetchAllItem();
	void removeItemById(int id);
}

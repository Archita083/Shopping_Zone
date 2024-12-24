package com.org.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.ItemDao;
import com.org.dto.Item;
import com.org.dto.User;

@Component
public class ItemDaoImpl implements ItemDao{

	EntityManagerFactory emf =Persistence.createEntityManagerFactory("archita");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et= em.getTransaction();
    
	@Override
	public void addAndUpdateItem(Item item) {
		// TODO Auto-generated method stub
		et.begin();
		em.merge(item);
		et.commit();
		
	}

	@Override
	public Item fetchItemById(int id) {
		// TODO Auto-generated method stub
		return em.find(Item.class, id);
	}

	@Override
	public List<Item> fetchAllItem() {
		// TODO Auto-generated method stub
		
        String jpql="select i from Item i";
		
		Query query=em.createQuery(jpql);
		
		List<Item> list=query.getResultList();
		
		for(Item it : list) {
			//System.out.println(it.getId());
			//System.out.println(it.getName());
			//System.out.println(it.getPrice());
			//System.out.println(it.getCategory());
			//System.out.println(it.getDescription());
			//System.out.println(it.getStocksleft());
			//System.out.println(it.getStocksold());
			//System.out.println(it.getProductId());
			//System.out.println("-------------");
			return list;
		}
		return null;
	}

	@Override
	public void removeItemById(int id) {
		// TODO Auto-generated method stub
		
        Item item =em.find(Item.class, id);
		
		User user=item.getUser();
		List<Item> items = user.getItems();
		
		items.remove(item);
		
		et.begin();
		em.merge(user);
		em.remove(item);
		et.commit();
		
	}

}

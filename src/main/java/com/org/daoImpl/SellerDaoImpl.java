package com.org.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.SellerDao;
import com.org.dto.Seller;

@Component
public class SellerDaoImpl implements SellerDao{
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("archita");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et= em.getTransaction();

	@Override
	public void insertAndUpdateSeller(Seller seller) {
		// TODO Auto-generated method stub
		et.begin();
		em.merge(seller);
		et.commit();
		
	}

	@Override
	public Seller fetchSellerByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		
		 String jpql="select s from Seller s where email='"+email+"' and password='"+password+"'";
	        
	        Query query =em.createQuery(jpql);
	        
	        List<Seller> list=query.getResultList();
	        
	        if(list!=null) {
	         
	           for(Seller sell : list) {
	        	   if(sell.getEmail().equals(email) && sell.getPassword().equals(password)) {
	        		   return sell;
	        	   }
			   }
	         
	        }
		return null;
	}

	@Override
	public Seller fetchSellerById(int id) {
		// TODO Auto-generated method stub
		return em.find(Seller.class, id);
	}

}

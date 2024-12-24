package com.org.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.UserDao;
import com.org.dto.User;

@Component
public class UserDaoImpl implements UserDao{
	
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("archita");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et= em.getTransaction();

	@Override
	public void addAndUpdateUser(User user) {
		
		et.begin();
		em.merge(user);
		et.commit();
		
	}

	@Override
	public User fetchUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		
		 String jpql="select u from User u where email='"+email+"' and password='"+password+"'";
	        
	        Query query =em.createQuery(jpql);
	        
	        List<User> list=query.getResultList();
	        
	        if(list!=null) {
	         
	           for(User usr : list) {
	        	   if(usr.getEmail().equals(email) && usr.getPassword().equals(password)) {
	        		   return usr;
	        	   }
			   }
	         
	        }
		return null;
	}

	@Override
	public User fetchUserById(int id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}

}

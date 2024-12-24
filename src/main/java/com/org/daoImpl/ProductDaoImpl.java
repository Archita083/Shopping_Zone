package com.org.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.ProductDao;
import com.org.dto.Product;
import com.org.dto.Seller;

@Component
public class ProductDaoImpl implements ProductDao{

	EntityManagerFactory emf =Persistence.createEntityManagerFactory("archita");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et= em.getTransaction();
	
	@Override
	public void addAndUpdateProduct(Product product) {
		// TODO Auto-generated method stub
		et.begin();
		em.merge(product);
		et.commit();
	}

	@Override
	public Product fetchProductById(int id) {
		// TODO Auto-generated method stub
		return em.find(Product.class, id);
	}

	@Override
	public List<Product> fetchAllProduct() {
		// TODO Auto-generated method stub
		
       String jpql="select p from Product p";
		
		Query query=em.createQuery(jpql);
		
		List<Product> list=query.getResultList();
		
		for(Product pro : list) {
			//System.out.println(pro.getId());
			//System.out.println(pro.getName());
			//System.out.println(pro.getPrice());
			//System.out.println(pro.getCategory());
			//System.out.println(pro.getDescription());
			//System.out.println(pro.getStockleft());
			//System.out.println(pro.getStocksold());
			//System.out.println("-------------");
			return list;
		}
		return null;
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		Product product =em.find(Product.class, id);
		
		Seller seller=product.getSeller();
		List<Product> products = seller.getProducts();
		
		products.remove(product);
		
		et.begin();
		em.merge(seller);
		em.remove(product);
		et.commit();
		
	}

}

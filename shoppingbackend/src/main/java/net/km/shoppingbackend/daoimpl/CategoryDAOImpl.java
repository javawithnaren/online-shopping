package net.km.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.km.shoppingbackend.dao.CategoryDAO;
import net.km.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	/*
	 * Driver : org.h2.Driver
	 * jdbc:h2:tcp://localhost/~/onlineshopping
	 * */
	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "from Category where active = :active";
		Query uery= sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		uery.setParameter("active", true);
		return uery.getResultList();
	}

	@Override
	public Category get(int id) {
		
	
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	
	public boolean add(Category category) {
		
		try{
			//add the category to db table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Category category) {
		try{
			//update the category to db table
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		try{
			category.setActive(false);
			//update the category to db table
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

}

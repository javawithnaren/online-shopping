package net.km.shoppingbackend.dao;

import java.util.List;

import net.km.shoppingbackend.dto.Category;

public interface CategoryDAO {
	boolean add(Category category);
	Category get(int id);
	List<Category> list();
	boolean update(Category category);
	boolean delete(Category category);

}

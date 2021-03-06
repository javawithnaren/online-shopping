package net.km.shoppingbackend.dao;

import java.util.List;

import net.km.shoppingbackend.dto.Product;

public interface ProductDAO {

	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//business methods
	
	List<Product> listActiveProducts();
	List<Product> listProductsByCategoryId(int categoryId);
	List<Product> getLatestActiveProducts(int count);
}

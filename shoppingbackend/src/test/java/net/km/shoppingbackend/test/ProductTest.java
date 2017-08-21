package net.km.shoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.km.shoppingbackend.dao.ProductDAO;
import net.km.shoppingbackend.dto.Category;
import net.km.shoppingbackend.dto.Product;

public class ProductTest {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.km.shoppingbackend");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	@Test
	public void testCRUDProduct(){
		/*
		Product pro = new Product();
		pro.setName("Oppo selfie S53");
		pro.setBrand("Oppo");
		pro.setDescription("Selfie Description");
		pro.setQuantity(1);
		pro.setActive(true);
		pro.setUnitPrice(10);
		pro.setCategoryId(3);
		pro.setSupplierId(3);
		
		assertEquals("Invalid data",true,productDAO.add(pro));
		
		product = productDAO.get(2);
		product.setName("Samsung Galaxy S3");
		
		assertEquals("Invalid data",true,productDAO.update(product));
		assertEquals("Invalid data",true,productDAO.delete(product));
		
		assertEquals("Invalid data",6,productDAO.list().size());*/
		
		//Test Business methods
		
		assertEquals("Invalid data",6,productDAO.listActiveProducts().size());
		assertEquals("Invalid data",4,productDAO.listProductsByCategoryId(3).size());
		assertEquals("Invalid data",5,productDAO.getLatestActiveProducts(5).size());
	}

}

package net.km.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.km.shoppingbackend.dao.CategoryDAO;
import net.km.shoppingbackend.dto.Category;

public class CategoryTest {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.km.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCateogry(){
	 * 
	 * Category cat = new Category(); cat.setName("Mobile");
	 * cat.setDescription("Mobile Description"); cat.setImageURL("CAT_1.png");
	 * 
	 * assertEquals("Successfully added the category",true,categoryDAO.add(cat))
	 * ;
	 * 
	 * }
	 */

	/*
	 * @Test public void get() { category=categoryDAO.get(1);
	 * assertEquals("Successfully fetche a single category","Mobile",category.
	 * getName()); }
	 */

	/*
	 * @Test public void updateCategory() { category=categoryDAO.get(1);
	 * category.setName("TV");
	 * 
	 * assertEquals("Successfully updated a single category in table",true,
	 * categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void deleteCategory() { category=categoryDAO.get(1);
	 * 
	 * assertEquals("Successfully deleted a single category from table",true,
	 * categoryDAO.delete(category)); }
	 * 
	 * 
	 * @Test public void listCategory() { List<Category>
	 * categories=categoryDAO.list();
	 * 
	 * assertEquals("Successfully fetched  a list category from table",1,
	 * categories.size()); }
	 */

	@Test
	public void testCRUDCategory() {
		// add operation
		Category cat = new Category();
		cat.setName("Mobile");
		cat.setDescription("Mobile Description");
		cat.setImageURL("CAT_1.png");

		assertEquals("Successfully added the category", true, categoryDAO.add(cat));
		cat = new Category();

		cat.setName("Television");
		cat.setDescription("Laptop Description");
		cat.setImageURL("CAT_2.png");

		assertEquals("Successfully added the category", true, categoryDAO.add(cat));

		// fetching and updating

		category = categoryDAO.get(2);
		category.setName("TV");

		assertEquals("Successfully updated a single category in table", true, categoryDAO.update(category));

		// deleting

		category = categoryDAO.get(2);

		assertEquals("Successfully deleted a single category from table", true, categoryDAO.delete(category));
		
		//list category
		List<Category> categories=categoryDAO.list();
		 
		 assertEquals("Successfully fetched  a list category from table",2,
		 categories.size());
	}
}

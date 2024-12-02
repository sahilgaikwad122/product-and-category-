package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.model.Category;
import com.model.Product;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		
		/*categorydao*/
		CategoryDao sd1 = new CategoryDao();
		Category s1 = new Category();
		s1.setName("perfume");
		System.out.println(sd1.insertStudent(s1));
		
		
		
		ProductDao pd1 = new ProductDao();
		Product s2 = new Product();
		s2.setName("jeans");
		s2.setPrice(200);
		s2.setCategoryId(3);
		System.out.println(pd1.insertStudentt(s2));
	
		
		
		
		
        CategoryDao sd = new CategoryDao();
	 	
        Category s11 = sd.findCategoryById(1);
		System.out.println(s11);
	
		
		
		
		
		ProductDao pd = new ProductDao();
		Product s111 = pd.findProductById(1);
		System.out.println(s111);
		
		
		
		
		
	/*	CategoryDao sd1 = new CategoryDao();
	 	
	 	Category s11 = sd1.findCategoryById(1);
	 	s11.setName("Electric");
	 */	System.out.println(sd1.updateCategory(s11));
	 
	
		ProductDao pd11 = new ProductDao();
		Product s1111 = pd11.findProductById(1);
		s1111.setName("Sail");
		s1111.setPrice(20000);
		s1111.setCategoryId(1);
		System.out.println(pd11.updateProduct(s1111));
	
		
		
		
		
	/*	CategoryDao sd = new CategoryDao();
		System.out.println(sd.deleteCategoryById(3));
	
	
	
	
		ProductDao pd = new ProductDao();
		System.out.println(pd.deleteProductById(1));
	*/
	}

}

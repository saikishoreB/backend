package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

//import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.ecomm.Config.DBConfig;
import com.ecomm.DAO.ProductDAO;
import com.ecomm.Model.Product;

import junit.framework.TestCase;

public class ProductDAOImpltest extends TestCase {

	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
	
	public void testFindAllProducts() 
	{
		List<Product> productList=productDAO.findAllProducts();
		assertNotNull(productList);
	}

	public void testFindProductById()
	{
		Product product1=productDAO.findProductById(42);
		assertNotNull(product1);
		int expectedId=42;
		int actualId=product1.getId();
		assertTrue(expectedId==actualId);
	}

	public void testFindProductByName() 
	{
		Product product2=productDAO.findProductByName("FCB");
		assertNotNull(product2);
		String expectedName="FCB";
		String actualName=product2.getProductName();
		assertTrue(expectedName.equals(actualName));
	}

	public void testAddProduct()
	{
		Product product=new Product();
		product.setId(2);
		product.setProductName("ATM");
		product.setProductDescription("kit");
		product.setProductSize("small");
		product.setProductQuantity(10);
		product.setProductPrice(100);
		assertEquals(true,productDAO.addProduct(product));
	}

	public void testUpdateProduct() {
		Product product3=productDAO.findProductById(43);
		product3.setProductName("Kerala");
		product3.setProductQuantity(15);
		productDAO.updateProduct(product3);
		assertTrue(product3.getProductQuantity()==15);
	}

	public void testDeleteProduct()
	{
		Product product4=productDAO.findProductById(44);
		assertEquals(true,productDAO.deleteProduct(product4.getId()));
	}


}

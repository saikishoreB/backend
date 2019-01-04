package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.ecomm.Config.DBConfig;
import com.ecomm.DAO.SupplierDAO;
import com.ecomm.Model.Supplier;

import junit.framework.TestCase;

public class SupplierDAOImpl extends TestCase{

	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	
	public void testFindAllSuppliers() 
	{
		List<Supplier> supplierList=supplierDAO.findAllSuppliers();
		assertNotNull(supplierList);
	}

	public void testFindSupplierById() 
	{
		Supplier supplier1=supplierDAO.findSupplierById(3);
		assertNotNull(supplier1);
		int expectedId=3;
		int actualId=supplier1.getSupplierId();
		assertTrue(expectedId==actualId);
	}

	public void testFindSupplierByName()
	{
		Supplier supplier2=supplierDAO.findSupplierByName("basics");
		assertNotNull(supplier2);
		String expectedName="basics";
		String actualName=supplier2.getSupplierName();
		assertTrue(expectedName.equals(actualName));
	}

	public void testAddSupplier()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(2);
		supplier.setSupplierName("SRT");
		supplier.setSupplierAddress("Chennai");
		supplier.setSupplierMobNo("89754");
		supplier.setSupplierMailId("srt@gmail.com");
		assertEquals(true,supplierDAO.addSupplier(supplier));
	}

	public void testUpdateSupplier()
	{
		Supplier supplier3=supplierDAO.findSupplierById(5);
		supplier3.setSupplierMobNo("91356");
		supplierDAO.updateSupplier(supplier3);
		assertTrue(supplier3.getSupplierMobNo()=="91356");
	}

	public void testDeleteSupplier()
	{
		Supplier supplier4=supplierDAO.findSupplierById(6);
		assertEquals(true,supplierDAO.deleteSupplier(supplier4.getSupplierId()));
	}


}

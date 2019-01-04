package com.ecomm.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	int supplierId;
	String supplierName;
	String supplierMobNo;
	String supplierAddress;
	String supplierMailId;
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierMobNo() {
		return supplierMobNo;
	}
	public void setSupplierMobNo(String supplierMobNo) {
		this.supplierMobNo = supplierMobNo;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getSupplierMailId() {
		return supplierMailId;
	}
	public void setSupplierMailId(String supplierMailId) {
		this.supplierMailId = supplierMailId;
	}
	
}

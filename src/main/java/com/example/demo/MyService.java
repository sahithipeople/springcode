package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
@org.springframework.stereotype.Service
public class MyService {
	   @Autowired
	   private  Myrepo rp;
	public List<Product> display() {
		
		return rp.findAll();
	}
	public void saveproduct(Product product) {
		rp.save(product);
	}
 public Product getProduct(long id) {
	 return rp.findById(id).get();
 }
public void delete(long id) {
	rp.deleteById(id);
}
}

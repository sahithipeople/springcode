package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Product {
 long id;
 @Column(name="name",nullable = false)
 String name;
 int price;
 public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
@Id
 @GeneratedValue(strategy =GenerationType.IDENTITY)
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}

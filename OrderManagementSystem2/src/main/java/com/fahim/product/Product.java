package com.fahim.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "product_id")
private int id;
private String name;
private float cost;

public Product() {
	super();
}


public Product(int id, String name, float cost) {
	super();
	this.id = id;
	this.name = name;
	this.cost = cost;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getCost() {
	return cost;
}
public void setCost(float cost) {
	this.cost = cost;
}

@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", cost=" + cost + "]";
}


}

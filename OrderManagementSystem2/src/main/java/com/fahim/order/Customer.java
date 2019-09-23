package com.fahim.order;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fahim.customer.Customer;
import com.fahim.lineItem.LineItem;

@Entity
@Table(name="Orders")
public class Customer {
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="order_total")
	private float total;
	@Column(name="order_date")
	private Date date;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	@OneToMany
	@JoinColumn(name = "lineItem_id")
	private Set<LineItem> items;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<LineItem> getItems() {
		return items;
	}
	public void setItems(Set<LineItem> items) {
		this.items = items;
	}
	public Customer(int id, float total, Date date, Customer customer, Set<LineItem> items) {
		super();
		this.id = id;
		this.total = total;
		this.date = date;
		this.customer = customer;
		this.items = items;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", total=" + total + ", date=" + date + ", customer=" + customer + ", items=" + items
				+ "]";
	}
	
	
	

}

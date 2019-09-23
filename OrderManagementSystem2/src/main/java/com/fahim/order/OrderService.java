package com.fahim.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired OrderRepository repository;
	
	public List<Customer> getOrders(){
		return repository.findAll();
	}
	
	public Customer getOrder(int id) {
		return repository.findById(id);
	}
	
	public void submitOrder(Customer order) {
	repository.save(order);	
	}
	
	public void updateOrder(Customer order) {
		repository.save(order);
	}
	
	public void deleteOrder(int id) {
		repository.deleteById(id);
	}
	
	public void cancelOrder(int id) {
		repository.findById(id);
	}
}

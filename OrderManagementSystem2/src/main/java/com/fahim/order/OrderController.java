package com.fahim.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired OrderService orderService;
	
	@RequestMapping("/orders")
	public List<Customer> orders(){
		return orderService.getOrders();
	}
	
	@RequestMapping("/orders/{orderId}")
	public Customer orders(@PathVariable int orderId) {
		return orderService.getOrder(orderId);
	}
	
	@RequestMapping(value="/orders",method = RequestMethod.POST)
	public void orders(Customer order) {
		orderService.submitOrder(order);
	}
	
	@RequestMapping(value="/orders/{orderId}",method = RequestMethod.PUT)
	public void orders(@PathVariable int orderId,Customer order) {
		orderService.updateOrder(order);
	}
	
	@RequestMapping(value="/orders/{orderId}",method = RequestMethod.DELETE)
	public void order(@PathVariable int orderId) {
		orderService.deleteOrder(orderId);
	}
	
	}

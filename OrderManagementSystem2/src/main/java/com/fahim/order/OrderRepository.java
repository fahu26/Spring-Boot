package com.fahim.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Customer, Integer>, CrudRepository<Customer, Integer> {

	public Customer findById(int id);
}

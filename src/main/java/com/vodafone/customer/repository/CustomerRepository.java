package com.vodafone.customer.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.vodafone.customer.entity.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>{
	List<Customer> findByLastName(@Param("name") String name);
	

}

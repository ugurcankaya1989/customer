package com.getir.customer.service;

import com.getir.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> getAllCustomer();
}

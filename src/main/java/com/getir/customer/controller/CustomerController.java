package com.getir.customer.controller;

import com.getir.customer.dto.OrderDTO;
import com.getir.customer.model.Customer;
import com.getir.customer.service.CustomerService;
import com.getir.customer.service.OrderClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final OrderClientService orderClientService;

    public CustomerController(CustomerService customerService, OrderClientService orderClientService) {
        this.customerService = customerService;
        this.orderClientService = orderClientService;
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.save(customer));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/get-order-list-by-customer/{id}")
    public ResponseEntity<List<OrderDTO>> getOrderListByCustomerId(@PathVariable("id") Long id){
        return ResponseEntity.ok(orderClientService.getOrdersByCustomerId(id));
    }
}

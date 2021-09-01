package com.getir.customer.init;

import com.getir.customer.model.Customer;
import com.getir.customer.repository.CustomerRepository;
import com.getir.customer.service.CustomerSequenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LoadInitialData{

    private final CustomerRepository customerRepository;
    private final CustomerSequenceService customerSequenceService;

    public void loadCustomerList() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(customerSequenceService.getSequenceNumber(Customer.SEQUENCE_NAME), "Ugur", "CANKAYA", "ugur.cankaya@gmail.com", LocalDateTime.now()));
        customerList.add(new Customer(customerSequenceService.getSequenceNumber(Customer.SEQUENCE_NAME), "George", "SMITH", "george.smith@gmail.com", LocalDateTime.now()));
        customerList.add(new Customer(customerSequenceService.getSequenceNumber(Customer.SEQUENCE_NAME), "Pascal", "GROSS", "pascal.gross@gmail.com", LocalDateTime.now()));
        customerList.add(new Customer(customerSequenceService.getSequenceNumber(Customer.SEQUENCE_NAME), "John", "OLA", "john.ola@gmail.com", LocalDateTime.now()));
        customerList.add(new Customer(customerSequenceService.getSequenceNumber(Customer.SEQUENCE_NAME), "Fernando", "SANTOS", "fernando.santos@gmail.com", LocalDateTime.now()));
        customerRepository.saveAll(customerList);
    }

}

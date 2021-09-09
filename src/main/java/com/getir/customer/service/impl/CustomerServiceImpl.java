package com.getir.customer.service.impl;

import com.getir.customer.exception.EmailIsBeingUsedByAnotherUserException;
import com.getir.customer.exception.EmailNotValidException;
import com.getir.customer.model.Customer;
import com.getir.customer.repository.CustomerRepository;
import com.getir.customer.service.CustomerSequenceService;
import com.getir.customer.service.CustomerService;
import com.getir.customer.util.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerSequenceService customerSequenceService;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Customer save(Customer customer) {
        if(EmailUtil.isEmailNotValid(customer.getEmail()))
            throw new EmailNotValidException();

        Customer email = customerRepository.findByEmail(customer.getEmail());
        if(Objects.nonNull(email))
            throw new EmailIsBeingUsedByAnotherUserException();
        customer.setRegisterDate(LocalDateTime.now());
        customer.setId(customerSequenceService.getSequenceNumber("customer_sequence"));
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}

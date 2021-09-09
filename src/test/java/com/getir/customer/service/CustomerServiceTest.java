package com.getir.customer.service;

import com.getir.customer.exception.EmailIsBeingUsedByAnotherUserException;
import com.getir.customer.model.Customer;
import com.getir.customer.repository.CustomerRepository;
import com.getir.customer.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @InjectMocks
    private CustomerServiceImpl customerService;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerSequenceService customerSequenceService;

    @Test
    public void saveCustomer_test() {
        Customer customer = new Customer(1l, "Ugur", "Cankaya", "ugur.cankaya@gmail.com", LocalDateTime.now());
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer savedCustomer = customerService.save(customer);

        assertEquals("Ugur", savedCustomer.getName());
    }

    @Test
    public void shouldThrowException_whenCustomerTryingToSaveExistingEmail_test() {
        Customer customer = new Customer(1l, "Ugur", "Cankaya", "ugur.cankaya@gmail.com", LocalDateTime.now());
        when(customerRepository.findByEmail(customer.getEmail())).thenReturn(customer);
        Assertions.assertThrows(EmailIsBeingUsedByAnotherUserException.class, () -> {
            customerService.save(customer);
        });
    }

    @Test
    void getAllCustomer_test() {
        List<Customer> customerList = Arrays.asList(new Customer(1l, "Ugur", "Cankaya", "ugur.cankaya@gmail.com", LocalDateTime.now()),new Customer(2l, "Antony", "Hopkins", "antony.hopkins@gmail.com", LocalDateTime.now()));
        when(customerRepository.findAll()).thenReturn(customerList);
        List<Customer> receivedList = customerService.getAllCustomer();
        assertEquals(2,receivedList.size());
    }

}

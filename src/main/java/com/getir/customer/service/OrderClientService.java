package com.getir.customer.service;

import com.getir.customer.dto.OrderDTO;

import java.util.List;

public interface OrderClientService {
    List<OrderDTO> getOrdersByCustomerId(Long id);
}

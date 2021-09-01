package com.getir.customer.service.impl;

import com.getir.customer.dto.OrderDTO;
import com.getir.customer.service.OrderClientService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderClientServiceImpl implements OrderClientService {

    @Override
    public List<OrderDTO> getOrdersByCustomerId(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String orderUrl = "http://order:8082/api/order/get-by-customer" + "?id=" + id;
        ParameterizedTypeReference<List<OrderDTO>> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<List<OrderDTO>> response = restTemplate.exchange(orderUrl, HttpMethod.GET, null, responseType);
        return response.getBody();
    }
}

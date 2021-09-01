package com.getir.customer.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailDTO {
    private long id;
    private long orderId;
    private long bookId;
    private int count;
    private BigDecimal totalPrice;
}

package com.getir.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSequence {
    @Id
    private String  id;
    private int seq;
}

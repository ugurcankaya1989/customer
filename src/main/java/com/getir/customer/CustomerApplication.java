package com.getir.customer;

import com.getir.customer.init.LoadInitialData;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableEurekaClient
public class CustomerApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CustomerApplication.class, args);
        LoadInitialData loadInitialData = context.getBean(LoadInitialData.class);
        loadInitialData.loadCustomerList();
    }

}

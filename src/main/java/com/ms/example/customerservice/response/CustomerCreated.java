package com.ms.example.customerservice.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCreated {
    private String customerId;

    public CustomerCreated(String customerId) {
        this.customerId = customerId;
    }
}

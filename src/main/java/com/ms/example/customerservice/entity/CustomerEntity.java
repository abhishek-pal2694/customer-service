package com.ms.example.customerservice.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CustomerEntity {

    private String customerId;

    private String firstName;

    private String lastName;

    private String emailId;

    private Integer phoneNumber;

    private Date creation_date;

    private String customerCategory;

    private List<AddressEntity> addresses;

    private SubscriptionEntity subscription;

}

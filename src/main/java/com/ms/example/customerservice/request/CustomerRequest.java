package com.ms.example.customerservice.request;

import com.ms.example.customerservice.entity.AddressEntity;
import com.ms.example.customerservice.entity.SubscriptionEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CustomerRequest {

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

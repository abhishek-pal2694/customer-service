package com.ms.example.customerservice.response;

import com.ms.example.customerservice.entity.AddressEntity;
import com.ms.example.customerservice.entity.CustomerEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Customer {

    private String customerId;

    private String firstName;

    private String lastName;

    private String emailId;

    private Integer phoneNumber;

    private Date creation_date;

    private String customerCategory;

    private List<Address> addressDetails;

    private Date subscriptionOffDate;

    //this is required for resolver
    private CustomerEntity customerEntity;

    public Customer(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
        this.customerId = customerEntity.getCustomerId();
        this.firstName = customerEntity.getFirstName();
        this.lastName = customerEntity.getLastName();
        this.emailId = customerEntity.getEmailId();
        this.phoneNumber = customerEntity.getPhoneNumber();
        this.creation_date = customerEntity.getCreation_date();
    }
//adress and subsOffDate in the resolver




}

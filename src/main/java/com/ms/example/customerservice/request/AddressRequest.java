package com.ms.example.customerservice.request;

import lombok.Data;

import java.util.Date;

@Data
public class AddressRequest {

    private Integer addressId;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private String postalCode;

    private Date lastUpdateDate;
}

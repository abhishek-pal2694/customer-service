package com.ms.example.customerservice.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AddressEntity {

    private Integer addressId;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private String postalCode;

    private Date lastUpdateDate;
}

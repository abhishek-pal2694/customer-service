package com.ms.example.customerservice.response;

import com.ms.example.customerservice.entity.AddressEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Address implements Cloneable {

    private Integer addressId;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postalCode;
    private Date lastUpdateDate;

    @Override
    public Address clone() throws CloneNotSupportedException {
        Address clone = (Address) super.clone();
        clone.setAddress1(this.getAddress1());
        return clone;
    }

    public Address(AddressEntity addressEntity) {
        this.addressId = addressEntity.getAddressId();
        this.address1 = addressEntity.getAddress1();
        this.address2 = addressEntity.getAddress2();
        this.city = addressEntity.getCity();
        this.state = addressEntity.getState();
        this.postalCode = addressEntity.getPostalCode();
        this.lastUpdateDate = addressEntity.getLastUpdateDate();
    }
}

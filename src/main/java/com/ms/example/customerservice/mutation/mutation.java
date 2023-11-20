
package com.ms.example.customerservice.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ms.example.customerservice.request.AddressRequest;
import com.ms.example.customerservice.request.SubscriptionRequest;
import com.ms.example.customerservice.response.Address;
import com.ms.example.customerservice.response.CustomerCreated;
import com.ms.example.customerservice.response.Subscription;
import com.ms.example.customerservice.service.CustomerService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@DgsComponent
public class mutation implements GraphQLMutationResolver {

    @Autowired
    CustomerService customerService;

    //Creating a customer
    @DgsMutation
    public CustomerCreated createCustomer(String custId,String firstName, String lastName, String email, String phoneNumber,
                                          List<AddressRequest> addresses, SubscriptionRequest subcscription){
        return new CustomerCreated(customerService.createCustomer(custId, firstName, lastName,
                email,phoneNumber,addresses,subcscription));
    }
}


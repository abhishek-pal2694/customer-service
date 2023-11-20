package com.ms.example.customerservice.service;

import com.ms.example.customerservice.entity.AddressEntity;
import com.ms.example.customerservice.entity.CustomerEntity;
import com.ms.example.customerservice.entity.SubscriptionEntity;
import com.ms.example.customerservice.request.AddressRequest;
import com.ms.example.customerservice.request.SubscriptionRequest;
import com.ms.example.customerservice.response.Address;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
public class CustomerService {

    @Autowired
    private WebClient webclient;

    public List<CustomerEntity> getCustomerDetails(){

        Flux<CustomerEntity> customerDetails = webclient.get()
                .uri("/getAllCustomers")
                .retrieve().bodyToFlux(CustomerEntity.class);
        customerDetails.collectList().block();

        List<CustomerEntity> customers = customerDetails.collectList().block();

        return customers;
    }

    public CustomerEntity getCustomerById(String customerId){
        CustomerEntity customer = webclient.get().uri("/getCustomer/" + customerId)
                    .retrieve().onStatus(HttpStatus::is4xxClientError, clientResponse -> {
                        throw new GraphQLException("customer not found");
                    }).bodyToMono(CustomerEntity.class).block();
        return customer;
    }

    public List<CustomerEntity> getFirstNCustomers(Integer limit){
        List<CustomerEntity> customers = webclient.get().uri("/getLimitedCustomers/" + limit)
                .retrieve().bodyToFlux(CustomerEntity.class).collectList().block();
        return customers;
    }

    public String createCustomer(String custId, String firstName, String lastName, String email, String phoneNumber,
                                 List<AddressRequest> addresses, SubscriptionRequest subscription){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(custId);
        customerEntity.setFirstName(firstName);
        customerEntity.setLastName(lastName);
        customerEntity.setEmailId(email);
        customerEntity.setPhoneNumber(Integer.valueOf(phoneNumber));
        List<AddressEntity> addressEntityList = new ArrayList<>();
        for (AddressRequest address: addresses
             ) {
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setAddressId(address.getAddressId());
            addressEntity.setAddress1(address.getAddress1());
            addressEntity.setAddress2(address.getAddress2());
            addressEntity.setCity(address.getCity());
            addressEntity.setLastUpdateDate(address.getLastUpdateDate());
            addressEntity.setPostalCode(address.getPostalCode());
            addressEntity.setState(address.getState());
            addressEntityList.add(addressEntity);
        }
        customerEntity.setAddresses(addressEntityList);
        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        subscriptionEntity.setSubscriptionId(subscription.getSubscriptionId());
        subscriptionEntity.setSubscriptionOnDate(subscription.getSubscriptionOnDate());
        subscriptionEntity.setSubscriptionOffDate(subscription.getSubscriptionOffDate());
        subscriptionEntity.setBalancePending(subscription.getBalancePending());
        customerEntity.setSubscription(subscriptionEntity);

        CustomerEntity customerEntityMono = webclient.post().uri("/createCustomer").
                body(Mono.just(customerEntity), CustomerEntity.class).retrieve()
                .onStatus(HttpStatus::is4xxClientError, response ->{
                    System.out.println("Error while creating customer");
                    throw new GraphQLException("Customer not created" );
                })
                .bodyToMono(CustomerEntity.class).block();

        return customerEntityMono.getCustomerId();
    }
}

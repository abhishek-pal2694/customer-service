package com.ms.example.customerservice.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ms.example.customerservice.entity.AddressEntity;
import com.ms.example.customerservice.entity.CustomerEntity;
import com.ms.example.customerservice.response.Address;
import com.ms.example.customerservice.response.Customer;
import com.ms.example.customerservice.service.CustomerService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@DgsComponent
public class Query implements GraphQLQueryResolver {

    @Autowired
    CustomerService customerService;

    //Fetching all customer Details
    @DgsQuery
    public List<Customer> customerDetails(){
        List<CustomerEntity> customers = customerService.getCustomerDetails();
        List<Customer> customerList = new ArrayList<>();
        for(CustomerEntity customerEntity: customers){
            customerList.add(new Customer(customerEntity));
        }
        return customerList;
    }

    //Fetching customer Details By Id
    @DgsQuery
    public Customer customerDetailsById(@InputArgument String custId){
        CustomerEntity customer = customerService.getCustomerById(custId);
        return new Customer(customer);
    }

    //fetching limited number of customers
    @DgsQuery
    public List<Customer> firstNCustomers(@InputArgument Integer limit){
        List<CustomerEntity> limitedCustomers = customerService.getFirstNCustomers(limit);
        List<Customer> customers = new ArrayList<>();
        for(CustomerEntity customerEntity: limitedCustomers){
            customers.add(new Customer(customerEntity));
        }
        return customers;
    }

}

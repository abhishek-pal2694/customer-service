package com.ms.example.customerservice.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.ms.example.customerservice.entity.AddressEntity;
import com.ms.example.customerservice.entity.SubscriptionEntity;
import com.ms.example.customerservice.response.Address;
import com.ms.example.customerservice.response.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerResolver implements GraphQLResolver<Customer> {

    public List<Address> getAddressDetails(Customer customer){

        List<Address> addresses = new ArrayList<>();

        if(customer.getCustomerEntity().getAddresses() != null){
            for(AddressEntity addressEntity : customer.getCustomerEntity().getAddresses()) {
                addresses.add(new Address(addressEntity));
            }
        }
        return addresses;
    }

    public Date getSubscriptionOffDate(Customer customer){

        SubscriptionEntity subscriptionEntity = customer.getCustomerEntity().getSubscription();
        Date subsOffDate = subscriptionEntity != null ? subscriptionEntity.getSubscriptionOffDate() : null;

        return subsOffDate;
    }


}

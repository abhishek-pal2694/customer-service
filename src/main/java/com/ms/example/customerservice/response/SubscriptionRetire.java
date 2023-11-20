package com.ms.example.customerservice.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriptionRetire {

    private Integer customerId;

    private Integer subscriptionId;

    public SubscriptionRetire(Integer customerId, Integer subscriptionId) {
        this.customerId = customerId;
        this.subscriptionId = subscriptionId;
    }
}

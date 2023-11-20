package com.ms.example.customerservice.response;

import com.ms.example.customerservice.entity.SubscriptionEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Subscription {

    private Integer subscriptionId;
    private Date subscriptionOnDate;
    private Date subscriptionOffDate;
    private Double balancePending;

    public Subscription(SubscriptionEntity subscriptionEntity) {
        this.subscriptionId = subscriptionEntity.getSubscriptionId();
        this.subscriptionOnDate = subscriptionEntity.getSubscriptionOnDate();
        this.subscriptionOffDate = subscriptionEntity.getSubscriptionOffDate();
        this.balancePending = subscriptionEntity.getBalancePending();
    }


}

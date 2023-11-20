package com.ms.example.customerservice.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SubscriptionEntity {


    private Integer subscriptionId;

    private Date subscriptionOnDate;

    private Date subscriptionOffDate;

    private Double balancePending;
}

package com.ms.example.customerservice.request;

import lombok.Data;

import java.util.Date;

@Data
public class SubscriptionRequest {

    private Integer subscriptionId;

    private Date subscriptionOnDate;

    private Date subscriptionOffDate;

    private Double balancePending;
}

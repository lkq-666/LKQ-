package com.lkq.lkqcrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersBusinessCustomer extends BaseEntity{
    private Integer ordersId;
    private Integer businessId;
    private Integer customerId;
}

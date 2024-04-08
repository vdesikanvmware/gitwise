package com.zolomart.order.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {

    private int paymentId;
    private PaymentStatus paymentStatus;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int pendingAmount;
}

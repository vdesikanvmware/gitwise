package com.zolomart.order.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {

    private RestTemplate restTemplate;

    @Value("${zolomart.user.url}")
    private String userUrl;

    @Value("${zolomart.cart.url}")
    private String cartUrl;

    @Value("${zolomart.payment.url}")
    private String paymentUrl;

    public OrderService() {
        this.restTemplate = new RestTemplate();
    }

    public List<User> getAllUsers() {
        String url = userUrl + "/users";
        List<User> result = restTemplate.getForObject(url, List.class);
        return result;
    }

    public String loginUser(int userId) {
        String url = userUrl + "/user/login?userId=" + userId;
        int result = restTemplate.getForObject(url, Integer.class);
        return result == 0 ? "No Such User." : "Logged in Successfully!";
    }

    public OrderDetails makeOrder(String productName, int price, int quantity) {
        String url = cartUrl + "/cart?productName=" + productName + "&price=" + price + "&quantity=" + quantity;
        OrderDetails orderDetails = restTemplate.postForObject(url, null, OrderDetails.class);
        return orderDetails;
    }

    public PaymentDetails makePayment(int orderId, int paymentAmount, int amountToPay) {
        String url = paymentUrl + "/makePayment?orderId=" + orderId + "&paymentAmount=" + paymentAmount + "&amountToPay=" + amountToPay;
        PaymentDetails paymentDetails = restTemplate.postForObject(url, null, PaymentDetails.class);
        return paymentDetails;
    }
}

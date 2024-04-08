package com.zolomart.order.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public List<User> getAllUsers() {
        return orderService.getAllUsers();
    }

    @GetMapping("/user/login")
    public String checkUserLogin(@RequestParam("userId") final int userId) {
        return orderService.loginUser(userId);
    }

    @PostMapping("/cart/addProduct")
    public OrderDetails addOrderToCart(@RequestParam("productName") final String productName,
                                       @RequestParam("price") final int price,
                                       @RequestParam("quantity") final int quantity) {
        return orderService.makeOrder(productName, price, quantity);
    }

    @PostMapping("/makePayment")
    public PaymentDetails makePayment(@RequestParam("orderId") final int orderId,
                                      @RequestParam("cost") final int paymentAmount,
                                      @RequestParam("amountToPay") final int amountToPay) {
        return orderService.makePayment(orderId, paymentAmount, amountToPay);
    }
}

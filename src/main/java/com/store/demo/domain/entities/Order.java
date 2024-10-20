package com.store.demo.domain.entities;

import com.store.demo.domain.status.OrderStatus;
import com.store.demo.domain.status.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;
    private LocalDateTime orderDate;
    private BigDecimal totalPrice;
    private OrderStatus status;
    private PaymentMethod paymentMethod;
    private String shippingAddress;
    private Client client;
    private List<Product>products;
}
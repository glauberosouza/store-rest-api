package com.store.demo.domain.entities;

import java.math.BigDecimal;
import java.util.List;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private int stockQuantity;
    private String category;
    private List<Order> order;
}
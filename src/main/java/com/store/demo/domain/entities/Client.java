package com.store.demo.domain.entities;

import java.util.List;

public class Client {
    private Long id;
    private String name;
    private String email;
    private String addres;
    private String phone;
    private List<Order> orders;
}
package com.store.demo.domain.entities;

import java.util.List;

public class Client {
    private Long id;
    private String name;
    private String email;
    private String addres;
    private String phone;
    private List<Order> orderJpaEntities;

    public Client() {
    }

    public Client(Long id, String name, String email, String addres, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.addres = addres;
        this.phone = phone;
    }

    public Client(Long id, String name, String email, String addres, String phone, List<Order> orderJpaEntities) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.addres = addres;
        this.phone = phone;
        this.orderJpaEntities = orderJpaEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrders() {
        return orderJpaEntities;
    }

    public void setOrders(List<Order> orderJpaEntities) {
        this.orderJpaEntities = orderJpaEntities;
    }
}
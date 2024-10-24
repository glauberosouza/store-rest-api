package com.store.demo.application.output.dbs.mysql.client;

import com.store.demo.application.output.dbs.mysql.order.OrderJpaEntity;
import com.store.demo.domain.entities.Client;
import com.store.demo.domain.entities.Order;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class ClientJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String addres;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = true)
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderJpaEntity> orderJpaEntities;

    public static ClientJpaEntity from(Client client){
        var clientJpaEntity = new ClientJpaEntity();
        clientJpaEntity.id = client.getId();
        clientJpaEntity.name = client.getName();
        clientJpaEntity.email = client.getEmail();
        clientJpaEntity.addres = client.getAddres();
        clientJpaEntity.phone = client.getPhone();
        if (client.getOrders() != null) {
            clientJpaEntity.orderJpaEntities = OrderJpaEntity.from(client.getOrders());
        } else {
            clientJpaEntity.orderJpaEntities = new ArrayList<>();
        }
        return clientJpaEntity;
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

    public List<OrderJpaEntity> getOrders() {
        return orderJpaEntities;
    }

    public void setOrders(List<OrderJpaEntity> orderJpaEntities) {
        this.orderJpaEntities = orderJpaEntities;
    }
}

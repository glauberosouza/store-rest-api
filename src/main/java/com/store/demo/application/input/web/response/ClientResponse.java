package com.store.demo.application.input.web.response;

import com.store.demo.domain.entities.Client;
import com.store.demo.domain.entities.Order;

import java.util.List;

public record ClientResponse(
        Long id,
        String name,
        String email,
        String addres,
        String phone,
        List<Order> orderJpaEntities
) {
    public static ClientResponse from(Client client){
        return new ClientResponse(
                client.getId(),
                client.getName(),
                client.getEmail(),
                client.getAddres(),
                client.getPhone(),
                client.getOrders()
        );
    }
}
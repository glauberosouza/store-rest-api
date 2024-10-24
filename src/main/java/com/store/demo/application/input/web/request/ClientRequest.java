package com.store.demo.application.input.web.request;

import com.store.demo.domain.entities.Client;
import com.store.demo.domain.entities.Order;

import java.util.List;

public record ClientRequest(
        String name,
        String email,
        String addres,
        String phone,
        List<Order> orderJpaEntities
) {
    public static Client from(ClientRequest clientRequest){
        var client = new Client();
        client.setName(clientRequest.name);
        client.setEmail(clientRequest.email);
        client.setAddres(clientRequest.addres);
        client.setPhone(clientRequest.phone);
        client.setOrders(clientRequest.orderJpaEntities);
        return client;
    }
    public static Client withOutOrderFrom(ClientRequest clientRequest){
        var client = new Client();
        client.setName(clientRequest.name);
        client.setEmail(clientRequest.email);
        client.setAddres(clientRequest.addres);
        client.setPhone(clientRequest.phone);
        return client;
    }
}
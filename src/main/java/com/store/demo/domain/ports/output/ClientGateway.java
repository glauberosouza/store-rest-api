package com.store.demo.domain.ports.output;

import com.store.demo.domain.entities.Client;

public interface ClientGateway {
    void saveClient(Client client);
}
package com.store.demo.domain.ports.input.clientUseCases;

import com.store.demo.domain.entities.Client;

public interface SaveClientUseCase {
    void saveClient(Client client);
}
package com.store.demo.domain.usecases.client;

import com.store.demo.domain.entities.Client;
import com.store.demo.domain.ports.input.clientUseCases.SaveClientUseCase;
import com.store.demo.domain.ports.output.ClientGateway;

public class SaveClientUseCaseImpl implements SaveClientUseCase {

    private final ClientGateway clientGateway;

    public SaveClientUseCaseImpl(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    @Override
    public void saveClient(Client client) {
        clientGateway.saveClient(client);
    }
}
package com.store.demo.application.output.dbs.mysql;

import com.store.demo.application.output.dbs.mysql.client.ClientJpaEntity;
import com.store.demo.application.output.dbs.mysql.client.ClientRepository;
import com.store.demo.domain.entities.Client;
import com.store.demo.domain.ports.output.ClientGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientMysqlGateway implements ClientGateway {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void saveClient(Client client) {
        var clientJpaEntity = ClientJpaEntity.from(client);
        clientRepository.save(clientJpaEntity);
    }
}
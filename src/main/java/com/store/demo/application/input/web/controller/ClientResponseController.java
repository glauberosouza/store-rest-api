package com.store.demo.application.input.web.controller;

import com.store.demo.application.input.web.request.ClientRequest;
import com.store.demo.domain.ports.output.ClientGateway;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientResponseController {
    private final ClientGateway clientGateway;

    public ClientResponseController(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }
    @PostMapping
    public ResponseEntity<Void> saveClient(@RequestBody @Valid ClientRequest clientRequest){
        var client = ClientRequest.from(clientRequest);
        clientGateway.saveClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
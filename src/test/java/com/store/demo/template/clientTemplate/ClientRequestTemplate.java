package com.store.demo.template.clientTemplate;

public class ClientRequestTemplate {
    public static ClientRequest creation(){
        return new ClientRequest(
                "Gabriel",
                "gabriel@gmail.com",
                "Rua da cidade do estado",
                "998776677"
        );
    }
}

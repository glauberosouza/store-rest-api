package com.store.demo.application.input.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.demo.BaseCompTest;
import com.store.demo.application.output.dbs.mysql.ClientMysqlGateway;
import com.store.demo.template.clientTemplate.ClientRequest;
import com.store.demo.template.clientTemplate.ClientRequestTemplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ClientResponseControllerTest extends BaseCompTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ClientMysqlGateway clientMysqlGateway;

    @DisplayName("Deve salvar um cliente com sucesso")
    @Test
    public void shouldSaveCliente() throws Exception {
        //GIVEN
        ClientRequest creation = ClientRequestTemplate.creation();
        var body = objectMapper.writeValueAsString(creation);
        //WHEN
            mockMvc.perform(post("clients")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(body)).andExpect(status().isCreated());

        //THEN
    }
}
package org.xgamerstechnologies.com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xgamerstechnologies.com.abstractions.clientmessage.BaseMessageController;
import org.xgamerstechnologies.com.abstractions.clientmessage.MessageModelConversions;
import org.xgamerstechnologies.com.entity.ClientMessage;
import org.xgamerstechnologies.com.payload.ClientMessagePayload;
import org.xgamerstechnologies.com.service.ClientMessageService;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/client-message")
public class ClientMessageController extends MessageModelConversions<ClientMessage> implements BaseMessageController<ClientMessage> {
    @Autowired
    private ClientMessageService clientMessageService;

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientMessagePayload> insertNewMessage(ClientMessagePayload payload) {
        ClientMessage message = super.convertToEntity(payload, ClientMessage.class);

        message = clientMessageService.insertNewMessage(message);

        ClientMessagePayload responsePayload = super.convertToPayload(message);
        return ResponseEntity.ok().body(responsePayload);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/get/{messageId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMessage(Long messageId) {
        return null;
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/get-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMessageList(
            @RequestParam(defaultValue = "0") String page,
            @RequestParam(required = false, defaultValue = "10") String size) {
        return null;
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/delete/{messageId}")
    public ResponseEntity<?> deleteMessage(Long messageId) {
        return null;
    }
}

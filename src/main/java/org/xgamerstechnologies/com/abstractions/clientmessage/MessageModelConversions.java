package org.xgamerstechnologies.com.abstractions.clientmessage;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.xgamerstechnologies.com.payload.ClientMessagePayload;

public class MessageModelConversions<ClientMessage> {
    @Autowired
    private ModelMapper modelMapper;

    public ClientMessagePayload convertToPayload(org.xgamerstechnologies.com.entity.ClientMessage message) {
        return modelMapper.map(message, ClientMessagePayload.class);
    }

    public ClientMessage convertToEntity(ClientMessagePayload payload, Class<ClientMessage> clazz) {
        return modelMapper.map(payload, clazz);
    }
}

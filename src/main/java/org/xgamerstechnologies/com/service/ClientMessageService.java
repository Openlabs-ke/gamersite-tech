package org.xgamerstechnologies.com.service;

import org.springframework.stereotype.Service;
import org.xgamerstechnologies.com.abstractions.clientmessage.MessageDeletion;
import org.xgamerstechnologies.com.abstractions.clientmessage.MessageInsertion;
import org.xgamerstechnologies.com.abstractions.clientmessage.MessageRetrieval;
import org.xgamerstechnologies.com.entity.ClientMessage;

@Service
public class ClientMessageService extends MessageRetrieval<ClientMessage>
        implements MessageInsertion<ClientMessage>,  MessageDeletion<ClientMessage> {
    @Override
    public void deleteMessage(Long id) {

    }

    @Override
    public ClientMessage insertNewMessage(ClientMessage clientMessage) {
        return null;
    }

    @Override
    public ClientMessage retrieveMessage(Long id) {
        return null;
    }
}

package org.xgamerstechnologies.com.service;

import org.xgamerstechnologies.com.abstractions.message.MessageDeletion;
import org.xgamerstechnologies.com.abstractions.message.MessageInsertion;
import org.xgamerstechnologies.com.abstractions.message.MessageRetrieval;
import org.xgamerstechnologies.com.entity.ClientMessage;

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

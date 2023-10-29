package org.xgamerstechnologies.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xgamerstechnologies.com.abstractions.clientmessage.MessageDeletion;
import org.xgamerstechnologies.com.abstractions.clientmessage.MessageInsertion;
import org.xgamerstechnologies.com.abstractions.clientmessage.MessageRetrieval;
import org.xgamerstechnologies.com.entity.ClientMessage;
import org.xgamerstechnologies.com.repository.ClientMessagesRepository;

import java.util.List;

@Service
public class ClientMessageService extends MessageRetrieval<ClientMessage>
        implements MessageInsertion<ClientMessage>,  MessageDeletion<ClientMessage> {
    @Autowired
    private ClientMessagesRepository clientMessagesRepository;

    @Override
    public void deleteMessage(Long id) {
        clientMessagesRepository.deleteById(id);
    }

    @Override
    public ClientMessage insertNewMessage(ClientMessage clientMessage) {
        return clientMessagesRepository.save(clientMessage);
    }

    @Override
    public ClientMessage retrieveMessage(Long id) {
        return clientMessagesRepository.findById(id).orElse(null);
    }

    public List<ClientMessage> getPagedList(int pageNumber, int pageSize) {
        return super.retrievePagedList(pageNumber, pageSize, ClientMessage.class);
    }
}

package org.xgamerstechnologies.com.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.xgamerstechnologies.com.abstractions.clientmessage.MessageDeletion;
import org.xgamerstechnologies.com.abstractions.clientmessage.MessageInsertion;
import org.xgamerstechnologies.com.abstractions.clientmessage.MessageRetrieval;
import org.xgamerstechnologies.com.entity.ClientMessage;
import org.xgamerstechnologies.com.repository.ClientMessagesRepository;

import java.util.List;

@Service
@Slf4j
public class ClientMessageService extends MessageRetrieval<ClientMessage>
        implements MessageInsertion<ClientMessage>,  MessageDeletion<ClientMessage> {
    @Autowired
    private ClientMessagesRepository clientMessagesRepository;

    @Override
    @CacheEvict(value = "messages_cache", key = "#id")
    public void deleteMessage(Long id) {
        clientMessagesRepository.deleteById(id);
    }

    @Override
    public ClientMessage insertNewMessage(ClientMessage clientMessage) {
        return clientMessagesRepository.save(clientMessage);
    }

    @Override
    @Cacheable(value = "messages_cache", key = "#id", unless = "#result == null")
    public ClientMessage retrieveMessage(Long id) {
        return clientMessagesRepository.findById(id).orElse(null);
    }

    public List<ClientMessage> getPagedList(int pageNumber, int pageSize) {
        return super.retrievePagedList(pageNumber, pageSize, ClientMessage.class);
    }
}

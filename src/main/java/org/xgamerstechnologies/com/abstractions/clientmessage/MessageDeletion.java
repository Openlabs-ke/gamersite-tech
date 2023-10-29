package org.xgamerstechnologies.com.abstractions.clientmessage;

public interface MessageDeletion<ClientMessage> {
    void deleteMessage(Long id);
}

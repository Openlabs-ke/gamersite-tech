package org.xgamerstechnologies.com.abstractions.message;

public interface MessageDeletion<ClientMessage> {
    void deleteMessage(Long id);
}

package org.xgamerstechnologies.com.abstractions.message;

public abstract class MessageRetrieval<ClientMessage> {
    public abstract ClientMessage retrieveMessage(Long id);
}

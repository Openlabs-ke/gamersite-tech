package org.xgamerstechnologies.com.abstractions.clientmessage;

public abstract class MessageRetrieval<ClientMessage> {
    public abstract ClientMessage retrieveMessage(Long id);
}

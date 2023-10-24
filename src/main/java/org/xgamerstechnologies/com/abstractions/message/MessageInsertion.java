package org.xgamerstechnologies.com.abstractions.message;

public interface MessageInsertion<ClientMessage> {
    ClientMessage insertNewMessage(ClientMessage message);
}

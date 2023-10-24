package org.xgamerstechnologies.com.abstractions.clientmessage;

public interface MessageInsertion<ClientMessage> {
    ClientMessage insertNewMessage(ClientMessage message);
}

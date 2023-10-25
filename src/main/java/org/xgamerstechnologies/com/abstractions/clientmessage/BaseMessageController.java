package org.xgamerstechnologies.com.abstractions.clientmessage;

import org.springframework.http.ResponseEntity;
import org.xgamerstechnologies.com.payload.ClientMessagePayload;

public interface BaseMessageController<ClientMessage> {
    ResponseEntity<?> insertNewMessage(ClientMessagePayload payload);
    ResponseEntity<?> getMessage(Long id);
    ResponseEntity<?> getMessageList(String page, String size);
    ResponseEntity<?> deleteMessage(Long id);
}

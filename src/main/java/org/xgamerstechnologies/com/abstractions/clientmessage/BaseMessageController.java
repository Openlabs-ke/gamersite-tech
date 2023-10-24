package org.xgamerstechnologies.com.abstractions.message;

import org.springframework.http.ResponseEntity;

public interface BaseMessageController<ClientMessage> {
    ResponseEntity<?> insertNewMessage();
    ResponseEntity<?> getMessage(Long id);
    ResponseEntity<?> getMessageList(String page, String size);
    ResponseEntity<?> deleteMessage(Long id);
}

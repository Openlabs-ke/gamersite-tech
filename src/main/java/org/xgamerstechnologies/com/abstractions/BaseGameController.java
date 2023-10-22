package org.xgamerstechnologies.com.abstractions;

import org.springframework.http.ResponseEntity;
import org.xgamerstechnologies.com.payload.GamePayload;

import java.util.List;

public interface BaseGameController<T> {
    ResponseEntity<?> insertGame(GamePayload insertGameReq);
    ResponseEntity<?> getGame(Long gameId);
    ResponseEntity<?> updateGame(GamePayload gamePayload, Long gameId);
    ResponseEntity<?> deleteGame(Long gameId);
    ResponseEntity<List<T>> getGameList(String page, String size);
}

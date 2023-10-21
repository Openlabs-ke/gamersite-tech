package org.xgamerstechnologies.com.abstractions;

import org.springframework.http.ResponseEntity;
import org.xgamerstechnologies.com.payload.GamePayload;

import java.util.List;

public interface BaseGameController<T> {
    ResponseEntity<T> insertGame(GamePayload insertGameReq);
    ResponseEntity<T> getGame(Long gameId);
    ResponseEntity<T> updateGame(GamePayload gamePayload);
    ResponseEntity<T> deleteGame(Long gameId);
    ResponseEntity<List<T>> getGameList(String page, String size);
}

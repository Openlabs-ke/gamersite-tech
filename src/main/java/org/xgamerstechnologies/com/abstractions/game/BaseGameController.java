package org.xgamerstechnologies.com.abstractions.game;

import org.springframework.http.ResponseEntity;
import org.xgamerstechnologies.com.payload.GamePayload;
import org.xgamerstechnologies.com.type.Game;

import java.util.List;

public interface BaseGameController<T extends Game> {
    ResponseEntity<?> insertGame(GamePayload insertGameReq);
    ResponseEntity<?> getGame(Long gameId);
    ResponseEntity<?> updateGame(GamePayload gamePayload, Long gameId);
    ResponseEntity<?> deleteGame(Long gameId);
    ResponseEntity<?> getGameList(String page, String size);
}

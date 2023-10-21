package org.xgamerstechnologies.com.abstractions;

import org.springframework.http.ResponseEntity;
import org.xgamerstechnologies.com.entity.ComputerGame;
import org.xgamerstechnologies.com.payload.request.InsertGameReq;
import org.xgamerstechnologies.com.payload.request.UpdateGameReq;

import java.util.List;

public interface BaseGameController<T> {
    ResponseEntity<T> insertGame(InsertGameReq insertGameReq);
    ResponseEntity<T> getGame(Long gameId);
    ResponseEntity<T> updateGame(UpdateGameReq updateGameReq);
    ResponseEntity<T> deleteGame(Long gameId);
    ResponseEntity<List<T>> getGameList(String page, String size);
}

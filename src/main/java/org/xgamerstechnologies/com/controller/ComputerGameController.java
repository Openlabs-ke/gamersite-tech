package org.xgamerstechnologies.com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xgamerstechnologies.com.abstractions.BaseGameController;
import org.xgamerstechnologies.com.entity.ComputerGame;
import org.xgamerstechnologies.com.payload.request.InsertGameReq;
import org.xgamerstechnologies.com.payload.request.UpdateGameReq;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/computer-game")
public class ComputerGameController implements BaseGameController<ComputerGame> {

    @Override
    public ResponseEntity<ComputerGame> insertGame(InsertGameReq insertGameReq) {
        return null;
    }

    @Override
    public ResponseEntity<ComputerGame> getGame(Long gameId) {
        return null;
    }

    @Override
    public ResponseEntity<ComputerGame> updateGame(UpdateGameReq updateGameReq) {
        return null;
    }

    @Override
    public ResponseEntity<ComputerGame> deleteGame(Long gameId) {
        return null;
    }

    @Override
    public ResponseEntity<List<ComputerGame>> getGameList(String page, String size) {
        return null;
    }
}

package org.xgamerstechnologies.com.controller;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xgamerstechnologies.com.abstractions.BaseGameController;
import org.xgamerstechnologies.com.abstractions.ModelConversions;
import org.xgamerstechnologies.com.entity.ComputerGame;
import org.xgamerstechnologies.com.payload.GamePayload;
import org.xgamerstechnologies.com.type.Game;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/computer-game")
public class ComputerGameController implements BaseGameController<ComputerGame>, ModelConversions<ComputerGame> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<ComputerGame> insertGame(GamePayload insertGameReq) {
        return null;
    }

    @Override
    public ResponseEntity<ComputerGame> getGame(Long gameId) {
        return null;
    }

    @Override
    public ResponseEntity<ComputerGame> updateGame(GamePayload gamePayload) {
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

    @Override
    public GamePayload convertToPayload(Game game) {
        GamePayload gamePayload = modelMapper.map(game, GamePayload.class);

        // TODO: add setters as needed
        return gamePayload;
    }

    @Override
    public ComputerGame convertToEntity(GamePayload gamePayload) {
        ComputerGame computerGame = modelMapper.map(gamePayload, ComputerGame.class);

        // TODO: add any setters here
        return computerGame;
    }
}

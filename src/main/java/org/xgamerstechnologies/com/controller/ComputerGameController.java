package org.xgamerstechnologies.com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xgamerstechnologies.com.abstractions.BaseGameController;
import org.xgamerstechnologies.com.abstractions.ModelConversions;
import org.xgamerstechnologies.com.entity.ComputerGame;
import org.xgamerstechnologies.com.payload.GamePayload;
import org.xgamerstechnologies.com.service.ComputerGameService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/computer-game")
public class ComputerGameController extends ModelConversions<ComputerGame> implements BaseGameController<ComputerGame> {

    @Autowired
    private ComputerGameService computerGameService;

    @Override
    @ResponseStatus(code  = HttpStatus.OK)
    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GamePayload> insertGame(@RequestBody GamePayload gamePayload) {
        ComputerGame computerGame = super.convertToEntity(gamePayload, ComputerGame.class);
        computerGame.setGamePlatform(gamePayload.assignCorrectGamePlatform(gamePayload.getGamePlatform()));

        computerGame = computerGameService.insertGame(computerGame);
        GamePayload insertedComputerGame = super.convertToPayload(computerGame);

        return ResponseEntity.ok().body(insertedComputerGame);
    }

    @Override
    @ResponseStatus(code  = HttpStatus.OK)
    @GetMapping(value = "/get/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ComputerGame> getGame(@PathVariable Long gameId) {
        return null;
    }

    @Override
    @ResponseStatus(code  = HttpStatus.OK)
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ComputerGame> updateGame(GamePayload gamePayload) {
        return null;
    }

    @Override
    @ResponseStatus(code  = HttpStatus.OK)
    @DeleteMapping(value = "/delete")
    public ResponseEntity<ComputerGame> deleteGame(Long gameId) {
        return null;
    }

    @Override
    @ResponseStatus(code  = HttpStatus.OK)
    @GetMapping(value = "/get-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ComputerGame>> getGameList(String page, String size) {
        return null;
    }
}

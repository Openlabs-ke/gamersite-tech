package org.xgamerstechnologies.com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.xgamerstechnologies.com.abstractions.BaseGameController;
import org.xgamerstechnologies.com.abstractions.GameModelConversions;
import org.xgamerstechnologies.com.entity.ComputerGame;
import org.xgamerstechnologies.com.payload.GamePayload;
import org.xgamerstechnologies.com.service.ComputerGameService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/computer-game")
public class ComputerGameController extends GameModelConversions<ComputerGame> implements BaseGameController<ComputerGame> {

    @Autowired
    private ComputerGameService computerGameService;

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GamePayload> insertGame(@RequestBody GamePayload gamePayload) {
        ComputerGame computerGame = super.convertToEntity(gamePayload, ComputerGame.class);
        computerGame.setGamePlatform(gamePayload.assignCorrectGamePlatform(gamePayload.getGamePlatform()));

        computerGame = computerGameService.insertGame(computerGame);
        GamePayload insertedComputerGame = super.convertToPayload(computerGame);

        return ResponseEntity.ok().body(insertedComputerGame);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/get/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GamePayload> getGame(@PathVariable Long gameId) {
        ComputerGame computerGame = computerGameService.retrieveGame(gameId);

        if(computerGame == null) {
            /*
             this is a new way of handling REST exceptions that does not need you to generate custom
             REST advisors. It can handle many types of errors.
             However, we still advice that you use REST advisor INTERNAL_SERVER_ERROR for global exception-handling,
             and other REST advisors for handling security-based exceptions thrown by @PreAuthorize, @PostAuthorize and @Secure
             */
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
        }

        GamePayload computerGamePayload = super.convertToPayload(computerGame);
        return ResponseEntity.ok().body(computerGamePayload);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(value = "/update/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GamePayload> updateGame(@RequestBody GamePayload gamePayload, @PathVariable Long gameId) {
        ComputerGame computerGame = computerGameService.retrieveGame(gameId);

        ComputerGame gameUpdate = super.convertToEntity(gamePayload, ComputerGame.class);
        gameUpdate.setId(computerGame.getId());

        computerGame = computerGameService.updateGame(gameUpdate);
        GamePayload updatedComputerGame = super.convertToPayload(computerGame);

        return ResponseEntity.ok().body(updatedComputerGame);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/delete/{gameId}")
    public ResponseEntity<?> deleteGame(@PathVariable Long gameId) {
        computerGameService.deleteGame(gameId);
        return ResponseEntity.ok().body(null);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/get-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GamePayload>> getGameList(
            @RequestParam(defaultValue = "0") String page,
            @RequestParam(required = false, defaultValue = "10") String size) {
        int pageNumber = Integer.parseInt(page);
        int pageSize = Integer.parseInt(size);

        List<ComputerGame> computerGames = computerGameService.getPagedList(pageNumber, pageSize);
        List<GamePayload> retrievedComputerGames = computerGames.stream().map(super::convertToPayload).toList();
        return ResponseEntity.ok().body(retrievedComputerGames);
    }
}

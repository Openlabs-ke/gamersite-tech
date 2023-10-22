package org.xgamerstechnologies.com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.xgamerstechnologies.com.abstractions.game.BaseGameController;
import org.xgamerstechnologies.com.abstractions.game.GameModelConversions;
import org.xgamerstechnologies.com.entity.PlaystationGame;
import org.xgamerstechnologies.com.payload.GamePayload;
import org.xgamerstechnologies.com.service.PlaystationGameService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/playstation-game")
public class PlaystationGameController extends GameModelConversions<PlaystationGame> implements BaseGameController<PlaystationGame> {

    @Autowired
    private PlaystationGameService playstationGameService;

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GamePayload> insertGame(@RequestBody GamePayload gamePayload) {
        PlaystationGame playstationGame = super.convertToEntity(gamePayload, PlaystationGame.class);
        playstationGame.setGamePlatform(gamePayload.assignCorrectGamePlatform(gamePayload.getGamePlatform()));

        playstationGame = playstationGameService.insertGame(playstationGame);
        GamePayload insertedPlaystationGame = super.convertToPayload(playstationGame);

        return ResponseEntity.ok().body(insertedPlaystationGame);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/get/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GamePayload> getGame(@PathVariable Long gameId) {
        PlaystationGame playstationGame = playstationGameService.retrieveGame(gameId);

        if(playstationGame == null) {
            /*
             this is a new way of handling REST exceptions that does not need you to generate custom
             REST advisors. It can handle many types of errors.
             However, we still advice that you use REST advisor INTERNAL_SERVER_ERROR for global exception-handling,
             and other REST advisors for handling security-based exceptions thrown by @PreAuthorize, @PostAuthorize and @Secure
             */
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
        }

        GamePayload playstationGamePayload = super.convertToPayload(playstationGame);
        return ResponseEntity.ok().body(playstationGamePayload);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(value = "/update/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GamePayload> updateGame(@RequestBody GamePayload gamePayload, @PathVariable Long gameId) {
        PlaystationGame playstationGame = playstationGameService.retrieveGame(gameId);

        PlaystationGame gameUpdate = super.convertToEntity(gamePayload, PlaystationGame.class);
        gameUpdate.setId(playstationGame.getId());

        playstationGame = playstationGameService.updateGame(gameUpdate);
        GamePayload updatedPlaystationGame = super.convertToPayload(playstationGame);

        return ResponseEntity.ok().body(updatedPlaystationGame);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/delete/{gameId}")
    public ResponseEntity<?> deleteGame(@PathVariable Long gameId) {
        playstationGameService.deleteGame(gameId);
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

        List<PlaystationGame> playstationGames = playstationGameService.getPagedList(pageNumber, pageSize);
        List<GamePayload> retrievedPlaystationGames = playstationGames.stream().map(super::convertToPayload).toList();
        return ResponseEntity.ok().body(retrievedPlaystationGames);
    }
}

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
import org.xgamerstechnologies.com.entity.XBoxGame;
import org.xgamerstechnologies.com.payload.GamePayload;
import org.xgamerstechnologies.com.service.XBoxGameService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/xbox-game")
public class XBoxGameController extends GameModelConversions<XBoxGame> implements BaseGameController<XBoxGame> {

    @Autowired
    private XBoxGameService xBoxGameService;

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GamePayload> insertGame(@RequestBody GamePayload gamePayload) {
        XBoxGame xBoxGame = super.convertToEntity(gamePayload, XBoxGame.class);
        xBoxGame.setGamePlatform(gamePayload.assignCorrectGamePlatform(gamePayload.getGamePlatform()));

        xBoxGame = xBoxGameService.insertGame(xBoxGame);
        GamePayload insertedXBoxGame = super.convertToPayload(xBoxGame);

        return ResponseEntity.ok().body(insertedXBoxGame);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/get/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GamePayload> getGame(@PathVariable Long gameId) {
        XBoxGame xBoxGame = xBoxGameService.retrieveGame(gameId);

        if(xBoxGame == null) {
            /*
             this is a new way of handling REST exceptions that does not need you to generate custom
             REST advisors. It can handle many types of errors.
             However, we still advice that you use REST advisor INTERNAL_SERVER_ERROR for global exception-handling,
             and other REST advisors for handling security-based exceptions thrown by @PreAuthorize, @PostAuthorize and @Secure
             */
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
        }

        GamePayload xBoxGamePayload = super.convertToPayload(xBoxGame);
        return ResponseEntity.ok().body(xBoxGamePayload);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(value = "/update/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GamePayload> updateGame(@RequestBody GamePayload gamePayload, @PathVariable Long gameId) {
        XBoxGame xBoxGame = xBoxGameService.retrieveGame(gameId);

        XBoxGame gameUpdate = super.convertToEntity(gamePayload, XBoxGame.class);
        gameUpdate.setId(xBoxGame.getId());

        xBoxGame = xBoxGameService.updateGame(gameUpdate);
        GamePayload updatedXBoxGame = super.convertToPayload(xBoxGame);

        return ResponseEntity.ok().body(updatedXBoxGame);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/delete/{gameId}")
    public ResponseEntity<?> deleteGame(@PathVariable Long gameId) {
        xBoxGameService.deleteGame(gameId);
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

        List<XBoxGame> xBoxGames = xBoxGameService.getPagedList(pageNumber, pageSize);
        List<GamePayload> retrievedXBoxGames = xBoxGames.stream().map(super::convertToPayload).toList();
        return ResponseEntity.ok().body(retrievedXBoxGames);
    }
}

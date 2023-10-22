package org.xgamerstechnologies.com.service;


import org.springframework.stereotype.Service;
import org.xgamerstechnologies.com.abstractions.GameDeletion;
import org.xgamerstechnologies.com.abstractions.GameInsertion;
import org.xgamerstechnologies.com.abstractions.GameRetrieval;
import org.xgamerstechnologies.com.abstractions.GameUpdation;
import org.xgamerstechnologies.com.entity.PlaystationGame;

@Service
public class PlaystationGameService implements GameInsertion<PlaystationGame>, GameRetrieval<PlaystationGame>, GameUpdation<PlaystationGame>, GameDeletion {
    @Override
    public void deleteGame(Long gameId) {

    }

    @Override
    public PlaystationGame insertGame(PlaystationGame playstationGame) {
        return null;
    }

    @Override
    public PlaystationGame retrieveGame(Long id) {
        return null;
    }

    @Override
    public PlaystationGame updateGame(PlaystationGame playstationGame) {
        return null;
    }
}

package org.xgamerstechnologies.com.service;


import org.springframework.stereotype.Service;
import org.xgamerstechnologies.com.abstractions.GameDeletion;
import org.xgamerstechnologies.com.abstractions.GameInsertion;
import org.xgamerstechnologies.com.abstractions.GameRetrieval;
import org.xgamerstechnologies.com.abstractions.GameUpdation;
import org.xgamerstechnologies.com.entity.PlaystationGame;

@Service
public class PlaystationGameService implements GameInsertion, GameRetrieval<PlaystationGame>, GameUpdation, GameDeletion {
    @Override
    public void deleteGame() {

    }

    @Override
    public void insertGame() {

    }

    @Override
    public PlaystationGame RetrieveGame() {
        return null;
    }

    @Override
    public void updateGame() {

    }
}

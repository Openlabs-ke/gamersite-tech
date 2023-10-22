package org.xgamerstechnologies.com.service;

import org.springframework.stereotype.Service;
import org.xgamerstechnologies.com.abstractions.GameDeletion;
import org.xgamerstechnologies.com.abstractions.GameInsertion;
import org.xgamerstechnologies.com.abstractions.GameRetrieval;
import org.xgamerstechnologies.com.abstractions.GameUpdation;
import org.xgamerstechnologies.com.entity.XBoxGame;

@Service
public class XBoxGameService implements GameInsertion<XBoxGame>, GameRetrieval<XBoxGame>, GameUpdation, GameDeletion {
    @Override
    public void deleteGame() {

    }

    @Override
    public XBoxGame insertGame(XBoxGame xboxGame) {
        return null;
    }

    @Override
    public XBoxGame retrieveGame(Long id) {
        return null;
    }

    @Override
    public void updateGame() {

    }
}

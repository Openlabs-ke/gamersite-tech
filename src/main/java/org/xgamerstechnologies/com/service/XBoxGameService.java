package org.xgamerstechnologies.com.service;

import org.springframework.stereotype.Service;
import org.xgamerstechnologies.com.abstractions.GameDeletion;
import org.xgamerstechnologies.com.abstractions.GameInsertion;
import org.xgamerstechnologies.com.abstractions.GameRetrieval;
import org.xgamerstechnologies.com.abstractions.GameUpdation;
import org.xgamerstechnologies.com.entity.XBoxGame;

@Service
public class XBoxGameService extends GameRetrieval<XBoxGame> implements GameInsertion<XBoxGame>, GameUpdation<XBoxGame>, GameDeletion {
    @Override
    public void deleteGame(Long gameId) {

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
    public XBoxGame updateGame(XBoxGame xboxGame) {
        return null;
    }
}

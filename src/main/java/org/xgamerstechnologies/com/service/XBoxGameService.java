package org.xgamerstechnologies.com.service;

import org.springframework.stereotype.Service;
import org.xgamerstechnologies.com.abstractions.GameDeletion;
import org.xgamerstechnologies.com.abstractions.GameInsertion;
import org.xgamerstechnologies.com.abstractions.GameRetrieval;
import org.xgamerstechnologies.com.abstractions.GameUpdation;
import org.xgamerstechnologies.com.entity.XBoxGame;

@Service
public class XBoxGameService implements GameInsertion, GameRetrieval<XBoxGame>, GameUpdation, GameDeletion {
    @Override
    public void deleteGame() {

    }

    @Override
    public void insertGame() {

    }

    @Override
    public XBoxGame RetrieveGame() {
        return null;
    }

    @Override
    public void updateGame() {

    }
}

package org.xgamerstechnologies.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xgamerstechnologies.com.abstractions.GameDeletion;
import org.xgamerstechnologies.com.abstractions.GameInsertion;
import org.xgamerstechnologies.com.abstractions.GameRetrieval;
import org.xgamerstechnologies.com.abstractions.GameUpdation;
import org.xgamerstechnologies.com.entity.ComputerGame;
import org.xgamerstechnologies.com.repository.ComputerGameRepository;

@Service
public class ComputerGameService implements GameInsertion<ComputerGame>, GameRetrieval<ComputerGame>, GameUpdation, GameDeletion {
    @Autowired
    private ComputerGameRepository computerGameRepository;

    @Override
    public void deleteGame() {

    }

    @Override
    public ComputerGame insertGame(ComputerGame computerGame) {
        return computerGameRepository.save(computerGame);
    }

    @Override
    public ComputerGame RetrieveGame() {
        return null;
    }

    @Override
    public void updateGame() {

    }
}

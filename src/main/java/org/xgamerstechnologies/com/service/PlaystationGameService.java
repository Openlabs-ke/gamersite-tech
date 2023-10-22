package org.xgamerstechnologies.com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xgamerstechnologies.com.abstractions.game.GameDeletion;
import org.xgamerstechnologies.com.abstractions.game.GameInsertion;
import org.xgamerstechnologies.com.abstractions.game.GameRetrieval;
import org.xgamerstechnologies.com.abstractions.game.GameUpdation;
import org.xgamerstechnologies.com.entity.PlaystationGame;
import org.xgamerstechnologies.com.repository.PlaystationGameRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlaystationGameService extends GameRetrieval<PlaystationGame> implements GameInsertion<PlaystationGame>, GameUpdation<PlaystationGame>, GameDeletion {
    @Autowired
    private PlaystationGameRepository playstationGameRepository;

    @Override
    public void deleteGame(Long gameId) {
        playstationGameRepository.deleteById(gameId);
    }

    @Override
    public PlaystationGame insertGame(PlaystationGame playstationGame) {
        return playstationGameRepository.save(playstationGame);
    }

    @Override
    public PlaystationGame retrieveGame(Long id) {
        Optional<PlaystationGame> playstationGame = playstationGameRepository.findById(id);
        return playstationGame.orElse(null);
    }

    @Override
    public PlaystationGame updateGame(PlaystationGame playstationGame) {
        return playstationGameRepository.save(playstationGame);
    }

    public List<PlaystationGame> getPagedList(int pageNumber, int pageSize) {
        return super.retrievePagedList(pageNumber, pageSize, PlaystationGame.class);
    }
}

package org.xgamerstechnologies.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xgamerstechnologies.com.abstractions.game.GameDeletion;
import org.xgamerstechnologies.com.abstractions.game.GameInsertion;
import org.xgamerstechnologies.com.abstractions.game.GameRetrieval;
import org.xgamerstechnologies.com.abstractions.game.GameUpdation;
import org.xgamerstechnologies.com.entity.XBoxGame;
import org.xgamerstechnologies.com.repository.XboxGameRepository;

import java.util.List;
import java.util.Optional;

@Service
public class XBoxGameService extends GameRetrieval<XBoxGame> implements GameInsertion<XBoxGame>, GameUpdation<XBoxGame>, GameDeletion {
    @Autowired
    private XboxGameRepository xboxGameRepository;

    @Override
    public void deleteGame(Long gameId) {
        xboxGameRepository.deleteById(gameId);
    }

    @Override
    public XBoxGame insertGame(XBoxGame xboxGame) {
        return xboxGameRepository.save(xboxGame);
    }

    @Override
    public XBoxGame retrieveGame(Long id) {
        Optional<XBoxGame> xBoxGame = xboxGameRepository.findById(id);
        return xBoxGame.orElse(null);
    }

    @Override
    public XBoxGame updateGame(XBoxGame xboxGame) {
        return xboxGameRepository.save(xboxGame);
    }

    public List<XBoxGame> getPagedList(int pageNumber, int pageSize) {
        return super.retrievePagedList(pageNumber, pageSize, XBoxGame.class);
    }
}

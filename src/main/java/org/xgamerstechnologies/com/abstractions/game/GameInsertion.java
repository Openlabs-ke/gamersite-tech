package org.xgamerstechnologies.com.abstractions.game;

import org.xgamerstechnologies.com.type.Game;

public interface GameInsertion<T extends Game> {
    T insertGame(T game);
}

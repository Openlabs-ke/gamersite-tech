package org.xgamerstechnologies.com.abstractions.game;

import org.xgamerstechnologies.com.type.Game;

public interface GameUpdation<T> {
    T updateGame(T game);
}

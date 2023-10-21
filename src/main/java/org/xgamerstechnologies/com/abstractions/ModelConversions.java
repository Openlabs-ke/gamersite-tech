package org.xgamerstechnologies.com.abstractions;

import org.xgamerstechnologies.com.payload.GamePayload;
import org.xgamerstechnologies.com.type.Game;

public interface ModelConversions<T> {
    public GamePayload convertToPayload(Game game);
    public T convertToEntity(GamePayload gamePayload);
}

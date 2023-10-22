package org.xgamerstechnologies.com.abstractions;

public interface GameRetrieval<T> {
    T retrieveGame(Long id);
}

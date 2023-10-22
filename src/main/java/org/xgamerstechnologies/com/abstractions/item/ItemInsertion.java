package org.xgamerstechnologies.com.abstractions.item;

import org.xgamerstechnologies.com.type.Item;

public interface ItemInsertion<T extends Item> {
    void insertItem(T item);
}

package org.xgamerstechnologies.com.abstractions.item;

import org.xgamerstechnologies.com.type.Item;

public interface ItemUpdation<T extends Item> {
    T updateItem(T item);
}

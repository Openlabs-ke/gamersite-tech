package org.xgamerstechnologies.com.abstractions.item;

import org.xgamerstechnologies.com.type.Item;

public interface ItemDeletion<T extends Item> {
    void deleteItem(Long id);
}

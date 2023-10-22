package org.xgamerstechnologies.com.abstractions.item;

import org.springframework.http.ResponseEntity;
import org.xgamerstechnologies.com.type.Item;

public interface BaseItemsController<T extends Item> {
    ResponseEntity<?> insertItem();
    ResponseEntity<?> updateItem(Long id);
    ResponseEntity<?> deleteItem(Long id);
    ResponseEntity<?> getItem(Long id);
    ResponseEntity<?> getItemList(String page, String size);
}

package org.xgamerstechnologies.com.abstractions.item;

import org.springframework.http.ResponseEntity;
import org.xgamerstechnologies.com.payload.ProductCategoryPayload;
import org.xgamerstechnologies.com.type.Item;

public interface BaseItemsController<T extends Item> {
    ResponseEntity<?> updateItem(Long id, ProductCategoryPayload payload);
    ResponseEntity<?> deleteItem(Long id);
    ResponseEntity<?> getItem(Long id);
    ResponseEntity<?> getItemList(String page, String size);
}

package org.xgamerstechnologies.com.abstractions.item;

import org.springframework.http.ResponseEntity;
import org.xgamerstechnologies.com.payload.ProductCategoryPayload;
import org.xgamerstechnologies.com.payload.ProductItemPayload;

public interface ProductItemBaseController<T> {
    ResponseEntity<?> insertItem(ProductItemPayload payload);
}

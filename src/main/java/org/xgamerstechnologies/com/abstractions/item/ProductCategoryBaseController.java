package org.xgamerstechnologies.com.abstractions.item;

import org.springframework.http.ResponseEntity;
import org.xgamerstechnologies.com.payload.ProductCategoryPayload;

public interface ProductCategoryBaseController<T> {
    ResponseEntity<?> insertItem(ProductCategoryPayload payload);
}

package org.xgamerstechnologies.com.abstractions.item;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.xgamerstechnologies.com.payload.ProductCategoryPayload;
import org.xgamerstechnologies.com.type.Item;

public abstract class ItemModelConversions<T extends Item> {
    @Autowired
    private ModelMapper modelMapper;

    public ProductCategoryPayload convertProductCategoryToPayload(Item item) {
        return modelMapper.map(item, ProductCategoryPayload.class);
    }

    public T convertProductCategoryToEntity(ProductCategoryPayload productCategoryPayload, Class<T> clazz) {
        return modelMapper.map(productCategoryPayload, clazz);
    }
}

package org.xgamerstechnologies.com.abstractions.item;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.xgamerstechnologies.com.entity.ProductCategory;
import org.xgamerstechnologies.com.entity.ProductItem;
import org.xgamerstechnologies.com.payload.ProductCategoryPayload;
import org.xgamerstechnologies.com.payload.ProductItemPayload;
import org.xgamerstechnologies.com.service.ProductItemService;
import org.xgamerstechnologies.com.type.Item;

public abstract class ItemModelConversions<T extends Item> {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductItemService productItemService;

    public final ProductCategoryPayload convertProductCategoryToPayload(ProductCategory productCategory) {
        Long itemCount = productItemService.countProductsInCategory(productCategory);

        ProductCategoryPayload payload =  modelMapper.map(productCategory, ProductCategoryPayload.class);
        payload.setItemNumber(itemCount);

        return payload;
    }

    public final T convertProductCategoryToEntity(ProductCategoryPayload productCategoryPayload, Class<T> clazz) {
        return modelMapper.map(productCategoryPayload, clazz);
    }

    public final T convertProductItemToEntity(ProductItemPayload productItemPayload, Class<T> clazz) {
        return modelMapper.map(productItemPayload, clazz);
    }

    public final ProductItemPayload convertProductItemToPayload(ProductItem productItem) {
        return modelMapper.map(productItem, ProductItemPayload.class);
    }
}

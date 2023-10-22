package org.xgamerstechnologies.com.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xgamerstechnologies.com.abstractions.item.ItemInsertion;
import org.xgamerstechnologies.com.entity.ProductCategory;
import org.xgamerstechnologies.com.repository.ProductCategoryRepository;

@Service
@Slf4j
public class ProductCategoryService implements ItemInsertion<ProductCategory> {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory insertItem(ProductCategory item) {
        return productCategoryRepository.save(item);
    }
}

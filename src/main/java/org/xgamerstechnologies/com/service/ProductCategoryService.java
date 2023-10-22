package org.xgamerstechnologies.com.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xgamerstechnologies.com.abstractions.item.ItemDeletion;
import org.xgamerstechnologies.com.abstractions.item.ItemInsertion;
import org.xgamerstechnologies.com.abstractions.item.ItemRetrieval;
import org.xgamerstechnologies.com.abstractions.item.ItemUpdation;
import org.xgamerstechnologies.com.entity.ProductCategory;
import org.xgamerstechnologies.com.repository.ProductCategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductCategoryService extends ItemRetrieval<ProductCategory>
        implements ItemInsertion<ProductCategory>, ItemUpdation<ProductCategory>, ItemDeletion<ProductCategory> {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public void insertItem(ProductCategory item) {
        productCategoryRepository.save(item);
    }

    @Override
    public ProductCategory updateItem(ProductCategory item) {
        return productCategoryRepository.save(item);
    }

    @Override
    public ProductCategory retrieveItem(Long id) {
        Optional<ProductCategory> optionalProductCategory = productCategoryRepository.findById(id);
        return optionalProductCategory.orElse(null);
    }

    @Override
    public void deleteItem(Long id) {
        productCategoryRepository.deleteById(id);
    }

    public List<ProductCategory> getPagedList(int pageNumber, int pageSize) {
        return super.retrievePagedList(pageNumber, pageSize, ProductCategory.class);
    }
}

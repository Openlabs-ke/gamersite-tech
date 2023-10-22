package org.xgamerstechnologies.com.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.xgamerstechnologies.com.abstractions.item.ItemDeletion;
import org.xgamerstechnologies.com.abstractions.item.ItemInsertion;
import org.xgamerstechnologies.com.abstractions.item.ItemRetrieval;
import org.xgamerstechnologies.com.abstractions.item.ItemUpdation;
import org.xgamerstechnologies.com.entity.ProductCategory;
import org.xgamerstechnologies.com.entity.ProductItem;
import org.xgamerstechnologies.com.repository.ProductItemRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductItemService extends ItemRetrieval<ProductItem>
        implements ItemInsertion<ProductItem>, ItemUpdation<ProductItem>, ItemDeletion<ProductItem> {
    @Autowired
    private ProductItemRepository productItemRepository;

    @Override
    public void deleteItem(Long id) {
        productItemRepository.deleteById(id);
    }

    @Override
    public void insertItem(ProductItem item) {
        productItemRepository.save(item);
    }

    @Override
    public ProductItem retrieveItem(Long id) {
        Optional<ProductItem> optionalProductItem = productItemRepository.findById(id);
        return optionalProductItem.orElse(null);
    }

    @Override
    public ProductItem updateItem(ProductItem item) {
        return productItemRepository.save(item);
    }

    public List<ProductItem> getPagedList(int pageNumber, int pageSize) {
        return super.retrievePagedList(pageNumber, pageSize, ProductItem.class);
    }

    public Long countProductsInCategory(ProductCategory category) {
        // create an example of a product Item and set it to the argument category
        ProductItem productItem = new ProductItem();
        productItem.setCategory(category);

        // create an Example<T> to use as a counter
        Example<ProductItem> example = Example.of(productItem);
        return productItemRepository.count(example);
    }
}

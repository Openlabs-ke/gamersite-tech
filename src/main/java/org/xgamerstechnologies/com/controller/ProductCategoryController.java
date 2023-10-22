package org.xgamerstechnologies.com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.xgamerstechnologies.com.abstractions.item.BaseItemsController;
import org.xgamerstechnologies.com.abstractions.item.ItemModelConversions;
import org.xgamerstechnologies.com.abstractions.item.ProductCategoryBaseController;
import org.xgamerstechnologies.com.entity.ProductCategory;
import org.xgamerstechnologies.com.payload.ProductCategoryPayload;
import org.xgamerstechnologies.com.service.ProductCategoryService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/product-category")
public class ProductCategoryController extends ItemModelConversions<ProductCategory>
        implements BaseItemsController<ProductCategory>, ProductCategoryBaseController<ProductCategory> {
    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductCategory> insertItem(@RequestBody ProductCategoryPayload payload) {
        ProductCategory newCategory = super.convertProductCategoryToEntity(payload, ProductCategory.class);
        productCategoryService.insertItem(newCategory);

        return ResponseEntity.ok().body(null);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(value = "/update/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductCategoryPayload> updateItem(@PathVariable Long categoryId, @RequestBody ProductCategoryPayload payload) {
        ProductCategory existingCategory = productCategoryService.retrieveItem(categoryId);
        ProductCategory updatedCategory = super.convertProductCategoryToEntity(payload, ProductCategory.class);
        updatedCategory.setId(existingCategory.getId());

        existingCategory = productCategoryService.updateItem(updatedCategory);
        ProductCategoryPayload updatedPayload = super.convertProductCategoryToPayload(existingCategory);
        return ResponseEntity.ok().body(updatedPayload);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/delete/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteItem(@PathVariable Long categoryId) {
        productCategoryService.deleteItem(categoryId);
        return ResponseEntity.ok().body(null);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/get/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductCategoryPayload> getItem(@PathVariable Long categoryId) {
        ProductCategory existingCategory = productCategoryService.retrieveItem(categoryId);
        if(existingCategory == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Category not Found");
        }

        ProductCategoryPayload responsePayload = super.convertProductCategoryToPayload(existingCategory);
        return ResponseEntity.ok().body(responsePayload);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/get-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductCategoryPayload>> getItemList(
            @RequestParam(defaultValue = "0") String page,
            @RequestParam(required = false, defaultValue = "10") String size) {
        int pageNumber = Integer.parseInt(page);
        int pageSize = Integer.parseInt(size);

        List<ProductCategory> productCategories = productCategoryService.getPagedList(pageNumber, pageSize);
        List<ProductCategoryPayload> payload = productCategories.stream().map(super::convertProductCategoryToPayload).toList();
        return ResponseEntity.ok().body(payload);
    }
}

package org.xgamerstechnologies.com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xgamerstechnologies.com.abstractions.item.BaseItemsController;
import org.xgamerstechnologies.com.abstractions.item.ItemModelConversions;
import org.xgamerstechnologies.com.abstractions.item.ProductCategoryBaseController;
import org.xgamerstechnologies.com.entity.ProductCategory;
import org.xgamerstechnologies.com.payload.ProductCategoryPayload;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/product-category")
public class ProductCategoryController extends ItemModelConversions<ProductCategory>
        implements BaseItemsController<ProductCategory>, ProductCategoryBaseController<ProductCategory> {
    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertItem(@RequestBody ProductCategoryPayload payload) {
        ProductCategory newCategory = super.convertProductCategoryToEntity(payload, ProductCategory.class);
        log.info("new category name: {}", newCategory.getItemName());
        return null;
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(value = "/update/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateItem(@PathVariable Long categoryId) {
        return null;
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/delete/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteItem(@PathVariable Long categoryId) {
        return null;
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/get/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getItem(@PathVariable Long categoryId) {
        return null;
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/get-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getItemList(
            @RequestParam(defaultValue = "0") String page,
            @RequestParam(required = false, defaultValue = "10") String size) {
        return null;
    }
}

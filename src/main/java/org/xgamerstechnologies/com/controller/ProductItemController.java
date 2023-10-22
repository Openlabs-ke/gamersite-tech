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
import org.xgamerstechnologies.com.abstractions.item.ProductItemBaseController;
import org.xgamerstechnologies.com.entity.ProductCategory;
import org.xgamerstechnologies.com.entity.ProductItem;
import org.xgamerstechnologies.com.payload.ProductCategoryPayload;
import org.xgamerstechnologies.com.payload.ProductItemPayload;
import org.xgamerstechnologies.com.service.ProductItemService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/product-item")
public class ProductItemController extends ItemModelConversions<ProductItem>
        implements BaseItemsController<ProductItem>, ProductItemBaseController<ProductItem> {
    @Autowired
    private ProductItemService productItemService;

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductCategory> insertItem(@RequestBody ProductItemPayload payload) {
        ProductItem newItem = super.convertProductItemToEntity(payload, ProductItem.class);
        productItemService.insertItem(newItem);

        return ResponseEntity.ok().body(null);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(value = "/update/{productId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductItemPayload> updateItem(@PathVariable Long productId, @RequestBody ProductCategoryPayload payload) {
        ProductItem existingItem = productItemService.retrieveItem(productId);
        ProductItem updatedCategory = super.convertProductCategoryToEntity(payload, ProductItem.class);
        updatedCategory.setId(existingItem.getId());

        existingItem = productItemService.updateItem(updatedCategory);
        ProductItemPayload updatedPayload = super.convertProductItemToPayload(existingItem);
        return ResponseEntity.ok().body(updatedPayload);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/delete/{productId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteItem(@PathVariable Long productId) {
        productItemService.deleteItem(productId);
        return ResponseEntity.ok().body(null);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/get/{productId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductItemPayload> getItem(@PathVariable Long productId) {
        ProductItem existingItem = productItemService.retrieveItem(productId);
        if(existingItem == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Item not Found");
        }

        ProductItemPayload responsePayload = super.convertProductItemToPayload(existingItem);
        return ResponseEntity.ok().body(responsePayload);
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/get-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductItemPayload>> getItemList(
            @RequestParam(defaultValue = "0") String page,
            @RequestParam(required = false, defaultValue = "10") String size) {
        int pageNumber = Integer.parseInt(page);
        int pageSize = Integer.parseInt(size);

        List<ProductItem> productItems = productItemService.getPagedList(pageNumber, pageSize);
        List<ProductItemPayload> payload = productItems.stream().map(super::convertProductItemToPayload).toList();
        return ResponseEntity.ok().body(payload);
    }
}

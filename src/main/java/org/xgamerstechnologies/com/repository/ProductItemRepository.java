package org.xgamerstechnologies.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xgamerstechnologies.com.entity.ProductItem;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}

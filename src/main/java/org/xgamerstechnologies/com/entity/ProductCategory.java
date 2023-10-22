package org.xgamerstechnologies.com.entity;

import lombok.*;
import org.xgamerstechnologies.com.type.Item;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "product_category")
public class ProductCategory extends Item implements Serializable {
    @Serial
    @Transient
    private static final long serialVersionUID = UUID.randomUUID().getLeastSignificantBits();

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
    private Set<ProductItem> productItems;
}

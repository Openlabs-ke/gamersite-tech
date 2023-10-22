package org.xgamerstechnologies.com.payload;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductCategoryPayload {
    private String itemName;
    private Integer itemNumber;
}

package org.xgamerstechnologies.com.payload;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductItemPayload {
    private Long id;
    private String name;
    private String productImage;
    private String productDescription;
}

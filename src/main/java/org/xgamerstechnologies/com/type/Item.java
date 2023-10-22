package org.xgamerstechnologies.com.type;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name", unique = true)
    @Size(min = 3, max = 50)
    private String itemName;
}

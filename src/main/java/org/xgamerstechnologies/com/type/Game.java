package org.xgamerstechnologies.com.type;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
    private Long id;

    @Column(name = "game_name", unique = true)
    @Size(min = 3, max = 100)
    private String gameName;

    @Column(name = "poster_link", unique = true, nullable = false)
    private String posterLink;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_released")
    private Date dateReleased;

    @Column(name = "game_description", nullable = false)
    @Basic
    private String gameDescription;

    @Column(name = "num_in_stock", nullable = false)
    private Integer numInStock;
}
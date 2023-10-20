package org.xgamerstechnologies.com.type;

import jakarta.validation.constraints.Size;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
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
    private LocalDate dateReleased;

    @Column(name = "game_description", nullable = false)
    @Basic
    private String gameDescription;

    @Column(name = "num_in_stock", nullable = false)
    private Long numInStock;
}
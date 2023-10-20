package org.xgamerstechnologies.com.type;

import jakarta.validation.constraints.Size;

import javax.persistence.*;

@MappedSuperclass
public class GenericGame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
    private Long id;

    @Column(name = "game_name", unique = true)
    @Size(min = 3, max = 100)
    private String gameName;

    @Column(name = "poster_link", unique = true, nullable = false)
    private String posterLink;
}
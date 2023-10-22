package org.xgamerstechnologies.com.entity;

import lombok.*;
import org.xgamerstechnologies.com.type.Game;
import org.xgamerstechnologies.com.type.enums.GamePlatform;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "playstation_games")
public class PlaystationGame extends Game implements Serializable {
    @Serial
    @Transient
    private static final long serialVersionUID = UUID.randomUUID().getLeastSignificantBits();

    @Enumerated(EnumType.STRING)
    @Column(name = "game_platform")
    private GamePlatform gamePlatform;
}

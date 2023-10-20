package org.xgamerstechnologies.com.entity;

import lombok.*;
import org.xgamerstechnologies.com.type.Game;
import org.xgamerstechnologies.com.type.enums.GamePlatform;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "computer_games")
public class ComputerGame extends Game {
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "game_platform")
    private GamePlatform gamePlatform;
}

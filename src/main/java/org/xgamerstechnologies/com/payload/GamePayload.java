package org.xgamerstechnologies.com.payload;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.xgamerstechnologies.com.type.enums.GamePlatform;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Slf4j
public class GamePayload {
    private String gameName;
    private String posterLink;
    private String releaseDate;
    private String gameDescription;
    private Integer numInStock;
    private String gamePlatform;

    public Date getReleaseDateAsDate(String releaseDate) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;

        try {
            date = dateFormatter.parse(releaseDate);
        } catch(ParseException ex) {
            log.error("At {}. Failed to convert releaseDate to Date. Cause: {}", GamePayload.class.toString(), ex.getMessage());
        }
        return date;
    }

    public String getReleaseDateAsString(Date releaseDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(releaseDate);
    }

    public GamePlatform assignCorrectGamePlatform(String gamePlatform) {
        GamePlatform platform = null;
        switch(gamePlatform) {
            case "PS2" -> {
                platform = GamePlatform.PS2;
            }
            case "PS3" -> {
                platform = GamePlatform.PS3;
            }
            case "PS4" -> {
                platform = GamePlatform.PS4;
            }
            case "PS5" -> {
                platform = GamePlatform.PS5;
            }
            case "Computer Game" -> {
                platform = GamePlatform.PERSONAL_COMPUTER;
            }
            case "Xbox" -> {
                platform = GamePlatform.XBOX;
            }
        }
        return platform;
    }
}

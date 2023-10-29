package org.xgamerstechnologies.com.payload;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ClientMessagePayload {
    private String messageSubject;
    private Long phoneNumber;
    private String emailAddress;
    private String message;
}

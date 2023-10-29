package org.xgamerstechnologies.com.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "client_messages")
public class ClientMessage implements Serializable {
    @Serial
    @Transient
    private static final long serialVersionUID = UUID.randomUUID().getLeastSignificantBits();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id")
    private Long id;

    @Column(nullable = false, name = "message_subject")
    @Basic
    private String messageSubject;

    @Column(name = "phone_number", nullable = false)
    @Size(min = 1, max = 10)
    private Long phoneNumber;

    @Column(name = "email_address")
    @Basic
    private String emailAddress;

    @Column(name = "message", nullable = false)
    @Basic
    private String message;
}

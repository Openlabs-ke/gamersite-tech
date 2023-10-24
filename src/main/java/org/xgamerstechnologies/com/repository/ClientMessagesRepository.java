package org.xgamerstechnologies.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xgamerstechnologies.com.entity.ClientMessage;

@Repository
public interface ClientMessagesRepository extends JpaRepository<ClientMessage, Long> {
}

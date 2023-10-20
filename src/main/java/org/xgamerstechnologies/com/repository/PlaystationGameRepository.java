package org.xgamerstechnologies.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xgamerstechnologies.com.entity.PlaystationGame;

@Repository
public interface PlaystationGameRepository extends JpaRepository<PlaystationGame, Long> {
}

package org.xgamerstechnologies.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xgamerstechnologies.com.entity.XBoxGame;

@Repository
public interface XboxGameRepository extends JpaRepository<XBoxGame, Long> {
}

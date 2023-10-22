package org.xgamerstechnologies.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xgamerstechnologies.com.entity.ComputerGame;

import java.util.Optional;


@Repository
public interface ComputerGameRepository extends JpaRepository<ComputerGame, Long> {
    Optional<ComputerGame> findById(Long id);
}

package com.qa.may.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.may.entity.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer>{

}

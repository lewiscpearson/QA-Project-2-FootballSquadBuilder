package com.qa.may.service;

import java.util.List;

import com.qa.may.entity.Player;

public interface PlayerService {
	
	Player getById(int id);
	
	List<Player> getAll();
	
	Player findByName(String name);
	
	Player findByPosition (String position);
	
	Player findByNationality (String nationality);
	
	Player create(Player player);
	
	Player update(int id, String name, String position, String nationality);
	
	void delete(int id);

}

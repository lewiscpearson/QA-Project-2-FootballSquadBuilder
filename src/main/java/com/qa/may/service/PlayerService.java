package com.qa.may.service;

import java.util.List;

import com.qa.may.entity.Player;

public interface PlayerService {
	
	Player getById(int id);
	
	List<Player> getAll();
	
	Player create(Player player);
	
	Player update(int id, String name, String position, Integer age, String nationality);
	
	void delete(int id);

}

package com.qa.may.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.may.entity.Player;
import com.qa.may.repo.PlayerRepo;

@Service
@Primary
public class PlayerServiceDB implements PlayerService{
	
	@Autowired
	private PlayerRepo repo;

	@Override
	public Player getById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<Player> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Player create(Player player) {
		return this.repo.save(player);
	}

	@Override
	public Player update(int id, String name, String position, Integer age, String nationality) {
		Player toUpdate = this.getById(id);
		if (name !=null)
			toUpdate.setName(name);
		if (position != null)
			toUpdate.setPosition(position);
		if (age != null)
			toUpdate.setAge(age);
		if (nationality != null)
			toUpdate.setNationality(nationality);
		
		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
		
	}
}

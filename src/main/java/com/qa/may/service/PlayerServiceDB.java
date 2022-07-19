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
	public Player findByName(String name) {
		return this.repo.findByNameStartingWithIgnoreCase(name);
	}

	@Override
	public Player findByPosition(String position) {
		return this.repo.findByPositionIgnoreCase(position);
	}

	@Override
	public Player findByNationality(String nationality) {
		return this.repo.findByNationalityIgnoreCase(nationality);
	}

	@Override
	public Player create(Player player) {
		return this.repo.save(player);
	}

	@Override
	public Player update(int id, String name, String position, String nationality) {
		Player toUpdate = this.getById(id);
		if (name !=null)
			toUpdate.setName(name);
		if (position != null)
			toUpdate.setPosition(position);
		if (nationality != null)
			toUpdate.setNationality(nationality);
		
		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
		
	}

}

package com.qa.may.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.may.entity.Player;
import com.qa.may.service.PlayerService;

@CrossOrigin
@RestController
public class PlayerController {

	
	@Autowired
	private PlayerService service;
	
	@GetMapping("/getPlayers")
	public List<Player> getAll() {
		return this.service.getAll();
	}
	
	@GetMapping("/getPlayer/{id}")
	public Player getById(@PathVariable int id) {
		return this.service.getById(id);
	}
	
	@PostMapping("/createPlayer")
	public ResponseEntity<Player> create(@RequestBody Player player){
		System.out.println(player);
		Player created = this.service.create(player);
		
		return new ResponseEntity<Player>(created, HttpStatus.CREATED);
	}
	
	@PatchMapping("/updatePlayer/{id}")
	public Player update(@PathVariable int id, @PathParam("name") String name, @PathParam("position") String position, @PathParam("age") Integer age, @PathParam("natioanlity") String nationality) {
		return this.service.update(id, name, position, age, nationality);
	}
	
	@DeleteMapping("/deletePlayer/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

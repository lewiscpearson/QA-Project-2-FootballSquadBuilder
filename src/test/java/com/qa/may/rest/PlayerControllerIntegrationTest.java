package com.qa.may.rest;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.may.entity.Player;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:player-schema.sql",
			     "classpath:player-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class PlayerControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Player testPlayer = new Player("Lewis Pearson", "Left Back", 23, "Scottish");
		String testPlayerAsJSON = this.mapper.writeValueAsString(testPlayer);
		RequestBuilder req = post("/createPlayer").content(testPlayerAsJSON).contentType(MediaType.APPLICATION_JSON);
		
		ResultMatcher checkStatus =status().is(201);
		Player createdPlayer = new Player(2, "Lewis Pearson", "Left Back", 23, "Scottish");
		String createdPlayerAsJSON = this.mapper.writeValueAsString(createdPlayer);
		ResultMatcher checkBody = content().json(createdPlayerAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);		
	}
	
	@Test
	void testRead() throws Exception{
		List<Player> players = new ArrayList<Player>();
		players.add(new Player(1, "Lewis Pearson", "Left Back", 23, "Scottish"));
		
		RequestBuilder req = get("/getPlayers");
		ResultMatcher checkStatus = status().is(200);
		this.mvc.perform(req).andExpect(checkStatus)
						.andExpect(content().json(this.mapper.writeValueAsString(players)));
	}
	
	@Test
	void testReadById() throws Exception{
		RequestBuilder req = get("/getPlayer/1");
		ResultMatcher checkStatus= status().isOk();
		this.mvc.perform(req).andExpect(checkStatus).andExpect(content().json(this.mapper.writeValueAsString(new Player(1, "Lewis Pearson", "Left Back", 23, "Scottish"))));
	}
	
	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/deletePlayer/1")).andExpect(status().isNoContent());
	}
	
	@Test
	void testUpdate() throws Exception {
		Player updated = new Player(1, "Lewis Pearson", "Left Back", 23, "Scottish");
		this.mvc.perform(patch("/updatePlayer/1?name=Lewis Pearson&position=Left Back&age=23&nationality=Scottish"))
						.andExpect(status().isOk()).andExpect(content().json(this.mapper.writeValueAsString(updated)));
	}
	

}

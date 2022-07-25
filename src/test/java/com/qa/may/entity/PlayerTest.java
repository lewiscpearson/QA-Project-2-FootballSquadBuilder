package com.qa.may.entity;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class PlayerTest {
	
	@Test
	public void testEquals() {
	EqualsVerifier.simple().forClass(Player.class).verify();
}
}

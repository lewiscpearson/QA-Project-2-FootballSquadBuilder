package com.qa.may.entity;


@Entity //Specifies that this is a table
public class Player {
	
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Implements auto increment for ID
	
	
}

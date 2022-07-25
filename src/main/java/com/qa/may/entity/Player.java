package com.qa.may.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity //Specifies that this is a table
public class Player {
	
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Implements auto increment for ID
	private Integer id;
	
	@Column (name ="name", nullable =false, unique = true)
	private String name;
	private String position;
	private int age;
	private String nationality;
	
	public Player() {
		super();
	}

	public Player(Integer id, String name, String position, int age, String nationality) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.age = age;
		this.nationality = nationality;
	}

	public Player(String name, String position, int age, String nationality) {
		super();
		this.name = name;
		this.position = position;
		this.age = age;
		this.nationality = nationality;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", position=" + position + ", age=" + age + ", nationality="
				+ nationality + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name, nationality, position);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return age == other.age && Objects.equals(name, other.name) && Objects.equals(nationality, other.nationality)
				&& Objects.equals(position, other.position);
	}
}

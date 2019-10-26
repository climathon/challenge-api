package de.hackerstolz.climathon.escapeapocalypse.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Challenge {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	public Challenge() {
		// jpa
	}

	public Challenge(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

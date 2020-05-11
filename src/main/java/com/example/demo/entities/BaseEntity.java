package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private boolean status = true;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
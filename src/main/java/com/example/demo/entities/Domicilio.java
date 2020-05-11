package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Domicilio extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String calle;
	private int numero;

	public Domicilio() {
		super();
	}

	public Domicilio(String calle, int numero, boolean state) {
		super();
		this.calle = calle;
		this.numero = numero;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}

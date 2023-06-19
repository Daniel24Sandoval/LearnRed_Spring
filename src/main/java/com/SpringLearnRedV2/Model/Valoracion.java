package com.SpringLearnRedV2.Model;

import java.sql.Date;

 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Valoraciones")
public class Valoracion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Texto;
	private double porcentaje;
	private Date fecha;

	//CARDINALIDAD
	@OneToOne
	private Usuario usuario;
	@OneToOne
	private Curso curso;

	 

	public Valoracion() {
		super();
	}


	public Valoracion(int id, String texto, double porcentaje, Date fecha) {
		super();
		this.id = id;
		Texto = texto;
		this.porcentaje = porcentaje;
		this.fecha = fecha;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTexto() {
		return Texto;
	}


	public void setTexto(String texto) {
		Texto = texto;
	}


	public double getPorcentaje() {
		return porcentaje;
	}


	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}



	}
 

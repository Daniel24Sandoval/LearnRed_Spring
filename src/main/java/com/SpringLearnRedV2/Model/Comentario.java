package com.SpringLearnRedV2.Model;

import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Comentarios")
public class Comentario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Comentario;
	private Date Fecha;
	//CARDINALIDAD
	@ManyToOne
	private Usuario usuario;
	@ManyToOne 
	private Curso curso;



	public Comentario() {
		super();
	}


	public Comentario(int id, String comentario, Date fecha) {
		super();
		this.id = id;
		Comentario = comentario;
		Fecha = fecha;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getComentario() {
		return Comentario;
	}


	public void setComentario(String comentario) {
		Comentario = comentario;
	}


	public Date getFecha() {
		return Fecha;
	}


	public void setFecha(Date fecha) {
		Fecha = fecha;
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

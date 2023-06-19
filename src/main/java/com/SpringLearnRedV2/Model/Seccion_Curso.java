package com.SpringLearnRedV2.Model;

import java.util.List;

 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Secciones_Curso")
public class Seccion_Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Nombre_Secc;
	private String N_Clases;
	//CARDINIALIDAD

	@ManyToOne
	private Curso curso;
	@OneToMany(mappedBy = "seccion_Curso")
	private List<Contenido> contenido;


	public Seccion_Curso() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre_Secc() {
		return Nombre_Secc;
	}


	public void setNombre_Secc(String nombre_Secc) {
		Nombre_Secc = nombre_Secc;
	}


	public String getN_Clases() {
		return N_Clases;
	}


	public void setN_Clases(String n_Clases) {
		N_Clases = n_Clases;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	public List<Contenido> getContenido() {
		return contenido;
	}


	public void setContenido(List<Contenido> contenido) {
		this.contenido = contenido;
	}
	 

	}

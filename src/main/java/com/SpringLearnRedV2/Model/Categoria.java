package com.SpringLearnRedV2.Model;

import java.util.List;

 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	//CARDINIALIDAD
	@OneToMany(mappedBy = "categoria")
	private List<Curso> curso;

	public Categoria() {
		super();
	}
	public Categoria(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Curso> getCurso() {
		return curso;
	}
	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}





	}

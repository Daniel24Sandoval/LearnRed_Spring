package com.SpringLearnRedV2.Model;

import java.util.List;

 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Creador_U")
public class CreadorU {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Titulo;
	private String Categoria;
	@OneToOne
	private Usuario usuario;
	@OneToMany(mappedBy = "creadorU")
	private List<Curso> curso;
	@OneToMany(mappedBy = "creadorU")
	private List<Grupo_Estudio> grupo_Estudio;
	@OneToMany(mappedBy = "creadorU")
	private List<Interacciones> interacciones;


	public CreadorU() {
	}
	public CreadorU(int id, String titulo, String categoria) {
		super();
		this.id = id;
		Titulo = titulo;
		Categoria = categoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Curso> getCurso() {
		return curso;
	}
	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}
	public List<Grupo_Estudio> getGrupo_Estudio() {
		return grupo_Estudio;
	}
	public void setGrupo_Estudio(List<Grupo_Estudio> grupo_Estudio) {
		this.grupo_Estudio = grupo_Estudio;
	}
	public List<Interacciones> getInteracciones() {
		return interacciones;
	}
	public void setInteracciones(List<Interacciones> interacciones) {
		this.interacciones = interacciones;
	} 

	}

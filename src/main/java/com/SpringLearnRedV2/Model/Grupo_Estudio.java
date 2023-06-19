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
@Table(name="Grupo_Estudios")
public class Grupo_Estudio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Tema;
	private int Capacidad;
	private String Codigo;
	//CARDINALIDAD
	@ManyToOne
	private CreadorU creadorU;
	@OneToMany(mappedBy = "grupo_Estudio")
	private List<Integracion_GrupoE> integracion_GrupoE;

	public Grupo_Estudio(int id, String tema, int capacidad, String codigo) {
		super();
		this.id = id;
		Tema = tema;
		Capacidad = capacidad;
		Codigo = codigo;
	}
	public Grupo_Estudio() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTema() {
		return Tema;
	}
	public void setTema(String tema) {
		Tema = tema;
	}
	public int getCapacidad() {
		return Capacidad;
	}
	public void setCapacidad(int capacidad) {
		Capacidad = capacidad;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public CreadorU getCreadorU() {
		return creadorU;
	}
	public void setCreadorU(CreadorU creadorU) {
		this.creadorU = creadorU;
	}
	public List<Integracion_GrupoE> getIntegracion_GrupoE() {
		return integracion_GrupoE;
	}
	public void setIntegracion_GrupoE(List<Integracion_GrupoE> integracion_GrupoE) {
		this.integracion_GrupoE = integracion_GrupoE;
	}
		


	}

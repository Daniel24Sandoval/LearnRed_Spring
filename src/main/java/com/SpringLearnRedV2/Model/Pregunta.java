package com.SpringLearnRedV2.Model;

import java.sql.Date;
import java.util.List;

 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Preguntas")
public class Pregunta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Texto;
	private Date Fecha;
	@ManyToOne
	private Publicacion publicacion;
	@ManyToOne 
	private Integracion_GrupoE integracion_GrupoE;
	@OneToMany(mappedBy = "pregunta")
	private List<Respuesta> respuesta;


	public Pregunta(int id, String texto, Date fecha) {
		super();
		this.id = id;
		Texto = texto;
		Fecha = fecha;
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


	public Date getFecha() {
		return Fecha;
	}


	public void setFecha(Date fecha) {
		Fecha = fecha;
	}


	public Publicacion getPublicacion() {
		return publicacion;
	}


	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}


	public Integracion_GrupoE getIntegracion_GrupoE() {
		return integracion_GrupoE;
	}


	public void setIntegracion_GrupoE(Integracion_GrupoE integracion_GrupoE) {
		this.integracion_GrupoE = integracion_GrupoE;
	}


	public List<Respuesta> getRespuesta() {
		return respuesta;
	}


	public void setRespuesta(List<Respuesta> respuesta) {
		this.respuesta = respuesta;
	}
	 


	}

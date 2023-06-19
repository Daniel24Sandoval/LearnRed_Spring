package com.SpringLearnRedV2.Model;

import java.sql.Date;

 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Respuesta")
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Texto;
	private Date Fecha;
	///CARDINALIDAD
	@ManyToOne
	private Pregunta pregunta;
	@ManyToOne
	private Integracion_GrupoE integracion_GrupoE;


	public Respuesta(int id, String texto) {
		super();
		this.id = id;
		this.Texto = texto;
	}
	public Respuesta() {
		super();
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
	public Pregunta getPregunta() {
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	public Integracion_GrupoE getIntegracion_GrupoE() {
		return integracion_GrupoE;
	}
	public void setIntegracion_GrupoE(Integracion_GrupoE integracion_GrupoE) {
		this.integracion_GrupoE = integracion_GrupoE;
	}





	}

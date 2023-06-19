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
@Table(name="Publicaciones")
public class Publicacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Texto;
	private String Tipo_Archivo;
	private String Archivo;
	private Date Fecha;

	@ManyToOne
	private Integracion_GrupoE integracion_GrupoE;
	@OneToMany(mappedBy = "publicacion")
	private List<Pregunta> pregunta;



	public Publicacion(int id, String texto, String tipo_Archivo, String archivo, Date fecha) {
		super();
		this.id = id;
		Texto = texto;
		Tipo_Archivo = tipo_Archivo;
		Archivo = archivo;
		Fecha = fecha;
	}
	public Publicacion() {
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
	public String getTipo_Archivo() {
		return Tipo_Archivo;
	}
	public void setTipo_Archivo(String tipo_Archivo) {
		Tipo_Archivo = tipo_Archivo;
	}
	public String getArchivo() {
		return Archivo;
	}
	public void setArchivo(String archivo) {
		Archivo = archivo;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public Integracion_GrupoE getIntegracion_GrupoE() {
		return integracion_GrupoE;
	}
	public void setIntegracion_GrupoE(Integracion_GrupoE integracion_GrupoE) {
		this.integracion_GrupoE = integracion_GrupoE;
	}
	public List<Pregunta> getPregunta() {
		return pregunta;
	}
	public void setPregunta(List<Pregunta> pregunta) {
		this.pregunta = pregunta;
	}	



		
		
	}
 

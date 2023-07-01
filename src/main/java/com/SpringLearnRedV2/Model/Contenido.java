package com.SpringLearnRedV2.Model;
import java.sql.Date;

 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Contenidos")
public class Contenido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Titulo;
	private String Descripcion;
	private String Archivo;
	private String Tipo_Archivo;
	private Date Fecha_Subida;
	private int Vizualizacion;
	//CARDINALIDAD
	@ManyToOne
	private Seccion_Curso seccion_Curso;
	public Contenido() {
		super();
	}
	public Contenido(int id, String titulo, String descripcion, String archivo, String tipo_Archivo, Date fecha_Subida,
			int vizualizacion) {
		super();
		this.id = id;
		Titulo = titulo;
		Descripcion = descripcion;
		Archivo = archivo;
		Tipo_Archivo = tipo_Archivo;
		Fecha_Subida = fecha_Subida;
		Vizualizacion = vizualizacion;
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
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getArchivo() {
		return Archivo;
	}
	public void setArchivo(String archivo) {
		Archivo = archivo;
	}
	public String getTipo_Archivo() {
		return Tipo_Archivo;
	}
	public void setTipo_Archivo(String tipo_Archivo) {
		Tipo_Archivo = tipo_Archivo;
	}
	public Date getFecha_Subida() {
		return Fecha_Subida;
	}
	public void setFecha_Subida(Date fecha_Subida) {
		Fecha_Subida = fecha_Subida;
	}
	public int getVizualizacion() {
		return Vizualizacion;
	}
	public void setVizualizacion(int vizualizacion) {
		Vizualizacion = vizualizacion;
	}
	public Seccion_Curso getSeccion_Curso() {
		return seccion_Curso;
	}
	public void setSeccion_Curso(Seccion_Curso seccion_Curso) {
		this.seccion_Curso = seccion_Curso;
	} 






	}

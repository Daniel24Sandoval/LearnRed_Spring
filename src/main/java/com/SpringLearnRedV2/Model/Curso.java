package com.SpringLearnRedV2.Model;

import java.util.List;

 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String Titulo_G;
private String Descripcion;
private String Anuncio;
private String Requisitos;
private String Horas;
private String Vizualizacion_G;
//CARDINALIDAD
@ManyToOne
private Categoria categoria;
@ManyToOne
private CreadorU creadorU;
@OneToOne(mappedBy = "curso")
private  Valoracion valoracion;
@OneToMany(mappedBy = "curso")
private List<Comentario> comentario;
@OneToMany(mappedBy = "curso")
private List<Registro_P> registro_P;
@OneToMany(mappedBy = "curso")
private List<Seccion_Curso> seccion_Curso;
@OneToMany(mappedBy = "curso")
private List<Interacciones> interacciones;

public Curso() {
	super();
}


public Curso(int id, String titulo_G, String descripcion, String anuncio, String requisitos, String horas,
		String vizualizacion_G) {
	super();
	this.id = id;
	Titulo_G = titulo_G;
	Descripcion = descripcion;
	Anuncio = anuncio;
	Requisitos = requisitos;
	Horas = horas;
	Vizualizacion_G = vizualizacion_G;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getTitulo_G() {
	return Titulo_G;
}


public void setTitulo_G(String titulo_G) {
	Titulo_G = titulo_G;
}


public String getDescripcion() {
	return Descripcion;
}


public void setDescripcion(String descripcion) {
	Descripcion = descripcion;
}


public String getAnuncio() {
	return Anuncio;
}


public void setAnuncio(String anuncio) {
	Anuncio = anuncio;
}


public String getRequisitos() {
	return Requisitos;
}


public void setRequisitos(String requisitos) {
	Requisitos = requisitos;
}


public String getHoras() {
	return Horas;
}


public void setHoras(String horas) {
	Horas = horas;
}


public String getVizualizacion_G() {
	return Vizualizacion_G;
}


public void setVizualizacion_G(String vizualizacion_G) {
	Vizualizacion_G = vizualizacion_G;
}


public Categoria getCategoria() {
	return categoria;
}


public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}


public CreadorU getCreadorU() {
	return creadorU;
}


public void setCreadorU(CreadorU creadorU) {
	this.creadorU = creadorU;
}


public Valoracion getValoracion() {
	return valoracion;
}


public void setValoracion(Valoracion valoracion) {
	this.valoracion = valoracion;
}


public List<Comentario> getComentario() {
	return comentario;
}


public void setComentario(List<Comentario> comentario) {
	this.comentario = comentario;
}


public List<Registro_P> getRegistro_P() {
	return registro_P;
}


public void setRegistro_P(List<Registro_P> registro_P) {
	this.registro_P = registro_P;
}


public List<Seccion_Curso> getSeccion_Curso() {
	return seccion_Curso;
}


public void setSeccion_Curso(List<Seccion_Curso> seccion_Curso) {
	this.seccion_Curso = seccion_Curso;
}


public List<Interacciones> getInteracciones() {
	return interacciones;
}


public void setInteracciones(List<Interacciones> interacciones) {
	this.interacciones = interacciones;
}
 


}

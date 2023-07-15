package com.SpringLearnRedV2.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Interacciones")
public class Interacciones {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private Date Fecha;
private String titulo;
//CARDINALIDAD
@ManyToOne
private Usuario usuario;
@ManyToOne 
private Curso curso;
@ManyToOne 
private CreadorU creadorU;
public Interacciones() {
	super();
}
public Interacciones(int id, Date fecha, String titulo) {
	super();
	this.id = id;
	Fecha = fecha;
	this.titulo = titulo;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getFecha() {
	return Fecha;
}
public void setFecha(Date fecha) {
	Fecha = fecha;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
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
public CreadorU getCreadorU() {
	return creadorU;
}
public void setCreadorU(CreadorU creadorU) {
	this.creadorU = creadorU;
}

}

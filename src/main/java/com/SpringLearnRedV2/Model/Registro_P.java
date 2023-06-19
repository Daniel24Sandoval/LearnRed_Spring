package com.SpringLearnRedV2.Model;

import java.sql.Date;

 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Registros_P")
public class Registro_P {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Boolean status;
	private double Sumatoria_Pago;
	private Date fecha_P;
	@ManyToOne
	private Curso curso;
	@ManyToOne
	private Administrador administrador;

	public Registro_P(int id, Boolean status, double sumatoria_Pago, Date fecha_P) {
		super();
		this.id = id;
		this.status = status;
		Sumatoria_Pago = sumatoria_Pago;
		this.fecha_P = fecha_P;
	}
	public Registro_P() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public double getSumatoria_Pago() {
		return Sumatoria_Pago;
	}
	public void setSumatoria_Pago(double sumatoria_Pago) {
		Sumatoria_Pago = sumatoria_Pago;
	}
	public Date getFecha_P() {
		return fecha_P;
	}
	public void setFecha_P(Date fecha_P) {
		this.fecha_P = fecha_P;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Administrador getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}





	}

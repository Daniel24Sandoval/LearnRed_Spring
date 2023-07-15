package com.SpringLearnRedV2.Model;

import java.sql.Date;
import java.util.List;

 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Usuarios")
public class Usuario {
	//AQUI VAMOS A CONFIGURAR LAS CARDINIALIDAD Y AUTOIMCR
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String nombre;
		private String apellido;
		private String correo;
		private String password;
		private String rol;
		private String estado;
		private Date fechaC;
		private Boolean creador;
		

		//CARDINIALIDAD DIRECTA:
				@OneToOne(mappedBy = "usuario")
				private CreadorU cradoru;
				@OneToOne(mappedBy = "usuario")
				private Valoracion valoracion;
				@OneToMany(mappedBy = "usuario")
				private List<Comentario> comentario;
				@OneToMany(mappedBy = "usuario")
				private List<Integracion_GrupoE> integracion_GrupoE;
				//CARDINIALIDAD INDIRECTA:
				@OneToMany(mappedBy = "usuario")
				private List<Interacciones> interacciones;
		public Usuario() {
		}




	 


 


		public Usuario(int id, String nombre, String apellido, String rol, String correo, String password, String estado,
				Date fechaC, Boolean creador) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.apellido = apellido;
			this.correo = correo;
			this.password = password;
			this.estado = estado;
			this.rol = rol;
			this.fechaC = fechaC;
			this.creador = creador;
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










		public String getApellido() {
			return apellido;
		}










		public void setApellido(String apellido) {
			this.apellido = apellido;
		}










		public String getCorreo() {
			return correo;
		}










		public void setCorreo(String correo) {
			this.correo = correo;
		}










		public String getPassword() {
			return password;
		}










		public void setPassword(String password) {
			this.password = password;
		}










		public String getRol() {
			return rol;
		}










		public void setRol(String rol) {
			this.rol = rol;
		}










		public String getEstado() {
			return estado;
		}










		public void setEstado(String estado) {
			this.estado = estado;
		}










		public Date getFechaC() {
			return fechaC;
		}










		public void setFechaC(Date fechaC) {
			this.fechaC = fechaC;
		}










		public Boolean getCreador() {
			return creador;
		}










		public void setCreador(Boolean creador) {
			this.creador = creador;
		}










		public CreadorU getCradoru() {
			return cradoru;
		}










		public void setCradoru(CreadorU cradoru) {
			this.cradoru = cradoru;
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










		public List<Integracion_GrupoE> getIntegracion_GrupoE() {
			return integracion_GrupoE;
		}










		public void setIntegracion_GrupoE(List<Integracion_GrupoE> integracion_GrupoE) {
			this.integracion_GrupoE = integracion_GrupoE;
		}










		public List<Interacciones> getInteracciones() {
			return interacciones;
		}










		public void setInteracciones(List<Interacciones> interacciones) {
			this.interacciones = interacciones;
		}










		@Override
		public String toString() {
			return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
					+ ", password=" + password + ", rol=" + rol + ", estado=" + estado + ", fechaC=" + fechaC
					+ ", creador=" + creador + ", cradoru=" + cradoru + ", valoracion=" + valoracion + ", comentario="
					+ comentario + ", integracion_GrupoE=" + integracion_GrupoE + ", interacciones=" + interacciones
					+ ", getId()=" + getId() + ", getNombre()=" + getNombre() + ", getApellido()=" + getApellido()
					+ ", getCorreo()=" + getCorreo() + ", getPassword()=" + getPassword() + ", getRol()=" + getRol()
					+ ", getEstado()=" + getEstado() + ", getFechaC()=" + getFechaC() + ", getCreador()=" + getCreador()
					+ ", getCradoru()=" + getCradoru() + ", getValoracion()=" + getValoracion() + ", getComentario()="
					+ getComentario() + ", getIntegracion_GrupoE()=" + getIntegracion_GrupoE() + ", getInteracciones()="
					+ getInteracciones() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
					+ super.toString() + "]";
		}






 
 
 
	 

		
		
		
		
		}

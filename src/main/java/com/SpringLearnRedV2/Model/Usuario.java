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
		private String Nombre_U;
		private String Apellido_U;
		private String Correo_U;
		private String Password_U;
		private String Estado_U;
		private Date FechaC_U;
		private Boolean Creador_U;
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
		
		public Usuario() {
		}


		public Usuario(int id, String nombre_U, String apellido_U, String correo_U, String password_U, String estado_U,
				Date fechaC_U, Boolean creador_U) {
			super();
			this.id = id;
			Nombre_U = nombre_U;
			Apellido_U = apellido_U;
			Correo_U = correo_U;
			Password_U = password_U;
			Estado_U = estado_U;
			FechaC_U = fechaC_U;
			Creador_U = creador_U;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getNombre_U() {
			return Nombre_U;
		}


		public void setNombre_U(String nombre_U) {
			Nombre_U = nombre_U;
		}


		public String getApellido_U() {
			return Apellido_U;
		}


		public void setApellido_U(String apellido_U) {
			Apellido_U = apellido_U;
		}


		public String getCorreo_U() {
			return Correo_U;
		}


		public void setCorreo_U(String correo_U) {
			Correo_U = correo_U;
		}


		public String getPassword_U() {
			return Password_U;
		}


		public void setPassword_U(String password_U) {
			Password_U = password_U;
		}


		public String getEstado_U() {
			return Estado_U;
		}


		public void setEstado_U(String estado_U) {
			Estado_U = estado_U;
		}


		public Date getFechaC_U() {
			return FechaC_U;
		}


		public void setFechaC_U(Date fechaC_U) {
			FechaC_U = fechaC_U;
		}


		public Boolean getCreador_U() {
			return Creador_U;
		}


		public void setCreador_U(Boolean creador_U) {
			Creador_U = creador_U;
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


		public Usuario(int id, String nombre_U, String apellido_U, String correo_U, String password_U, String estado_U,
				Date fechaC_U, Boolean creador_U, CreadorU cradoru, Valoracion valoracion, List<Comentario> comentario,
				List<Integracion_GrupoE> integracion_GrupoE) {
			super();
			this.id = id;
			Nombre_U = nombre_U;
			Apellido_U = apellido_U;
			Correo_U = correo_U;
			Password_U = password_U;
			Estado_U = estado_U;
			FechaC_U = fechaC_U;
			Creador_U = creador_U;
			this.cradoru = cradoru;
			this.valoracion = valoracion;
			this.comentario = comentario;
			this.integracion_GrupoE = integracion_GrupoE;
		}
		

		
		
		
		
		
		}

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
@Table(name="Integracion_GrupoEs")
public class Integracion_GrupoE {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String codigo;
	private Date fecha;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Grupo_Estudio grupo_Estudio;
	@OneToMany(mappedBy = "integracion_GrupoE")
	private List<Publicacion> publicacion;
	@OneToMany(mappedBy = "integracion_GrupoE")
	private List<Pregunta> pregunta;
	@OneToMany(mappedBy = "integracion_GrupoE")
	private List<Respuesta> respuesta;
	public Integracion_GrupoE(int id, String codigo, Date fecha) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fecha = fecha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Grupo_Estudio getGrupo_Estudio() {
		return grupo_Estudio;
	}
	public void setGrupo_Estudio(Grupo_Estudio grupo_Estudio) {
		this.grupo_Estudio = grupo_Estudio;
	}
	public List<Publicacion> getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(List<Publicacion> publicacion) {
		this.publicacion = publicacion;
	}
	public List<Pregunta> getPregunta() {
		return pregunta;
	}
	public void setPregunta(List<Pregunta> pregunta) {
		this.pregunta = pregunta;
	}
	public List<Respuesta> getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(List<Respuesta> respuesta) {
		this.respuesta = respuesta;
	}
	 
	}

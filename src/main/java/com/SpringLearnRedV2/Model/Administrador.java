package com.SpringLearnRedV2.Model;

import java.util.List;

 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Administradores")
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Nombre;
	private String Apellido;
	private String Correo;
	private String Password;
	private String tipo;
	private String Dni;
	private String telefono;

	//CARDINALIDAD
	@OneToMany(mappedBy = "administrador")
	private List<Registro_P> registro_p;



	public Administrador(int id, String nombre, String apellido, String correo, String password, String tipo, String dni,
			String telefono) {
		super();
		this.id = id;
		Nombre = nombre;
		Apellido = apellido;
		Correo = correo;
		Password = password;
		this.tipo = tipo;
		Dni = dni;
		this.telefono = telefono;
	}
	public Administrador() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public List<Registro_P> getRegistro_p() {
		return registro_p;
	}
	public void setRegistro_p(List<Registro_P> registro_p) {
		this.registro_p = registro_p;
	}




	}

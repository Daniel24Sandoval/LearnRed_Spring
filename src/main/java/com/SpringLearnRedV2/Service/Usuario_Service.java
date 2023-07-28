package com.SpringLearnRedV2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.SpringLearnRedV2.Model.Contenido;
import com.SpringLearnRedV2.Model.Curso;
import com.SpringLearnRedV2.Model.Interacciones;
import com.SpringLearnRedV2.Model.Usuario;

 
@Service
public interface Usuario_Service {
	public Usuario save(Usuario usuario);
	public Optional<Usuario> get(Integer id);
	public List<Usuario> finaAll();
	public Optional<Usuario> findByCorreo(String correo);
	//public Optional<Usuario> findByid(int id);
	public Contenido updateVizualizacion(int Vizualizacion,int idContenido);
	public Usuario updatemodCreadorById(boolean creadror, int idusario);
	public Interacciones save(Interacciones interacciones, int 	creadorU_id,int	curso_id	, int usuario_id);
	public List<Interacciones> findAllByUsuarioId(int id);
	public List<Curso>findCursosByCategoria(int categoriaid);
	  public List<Curso> findAllCursosnormal();
	 }

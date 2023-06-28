package com.SpringLearnRedV2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.SpringLearnRedV2.Model.Usuario;

 
@Service
public interface Usuario_Service {
	public Usuario save(Usuario usuario);
	public Optional<Usuario> get(Integer id);
	public List<Usuario> finaAll();
	///public Optional<Usuario> findByCorreo_U(String Correo_U);
	 }

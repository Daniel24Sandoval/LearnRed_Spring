package com.SpringLearnRedV2.Service;

import java.util.List;
import java.util.Optional;

import com.SpringLearnRedV2.Model.Usuario;

 

public interface Usuario_Service {
	public Usuario save(Usuario usuario);
	public Optional<Usuario> get(Integer id);
	public List<Usuario> finaAll();
	 }

package com.SpringLearnRedV2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringLearnRedV2.Dao.Usuario_Dao;
import com.SpringLearnRedV2.Model.Usuario;

 
@Service
public class Usuario_Service_Implem  implements Usuario_Service{

	@Autowired
	private Usuario_Dao usuario_Dao;
	
	
	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuario_Dao.save(usuario);
	}

	@Override
	public Optional<Usuario> get(Integer id) {
		// TODO Auto-generated method stub
		return usuario_Dao.findById(id);
	}

	@Override
	public List<Usuario> finaAll() {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public Optional<Usuario> findByCorreo_U(String Correo_U) {
	// TODO Auto-generated method stub
	// return usuario_Dao.findByCorreo_U(Correo_U);
	// }
 
	
		 
		 
	  
}

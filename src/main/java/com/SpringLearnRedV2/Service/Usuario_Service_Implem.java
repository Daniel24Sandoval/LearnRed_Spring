package com.SpringLearnRedV2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringLearnRedV2.Dao.Contenido_Dao;
import com.SpringLearnRedV2.Dao.Usuario_Dao;
import com.SpringLearnRedV2.Model.Contenido;
import com.SpringLearnRedV2.Model.Usuario;

 
@Service
public class Usuario_Service_Implem  implements Usuario_Service{

	@Autowired
	private Usuario_Dao usuario_Dao;
	@Autowired
	private Contenido_Dao contenido_Dao;
	
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

	@Override
	public Optional<Usuario> findByCorreo(String correo) {
		// TODO Auto-generated method stub
		return usuario_Dao.findByCorreo(correo);
	}

	@Override
	public Contenido updateVizualizacion(int nuevoNumeroVistas, int idContenido) {
	    Contenido contenido = contenido_Dao.findById((long) idContenido).orElse(null);
	    if (contenido != null) {
	        contenido.setVizualizacion(nuevoNumeroVistas);
	        return contenido_Dao.save(contenido);
	    } else {
	        // Manejar el caso cuando no se encuentra el contenido
	        return null;
	    }
	}

	@Override
	public Usuario updatemodCreadorById(boolean creadror, int idusario) {
		// TODO Auto-generated method stub
		Usuario usuario = usuario_Dao.findById(idusario).orElse(null);
		if(usuario !=null) {
			usuario.setCreador(creadror);
			return usuario_Dao.save(usuario);
		}else {
			return null;
		}
		
		
		
		
	}


	 

 
 
	
		 
		 
	  
}

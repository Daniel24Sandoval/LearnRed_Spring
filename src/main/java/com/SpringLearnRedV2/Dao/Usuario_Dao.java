package com.SpringLearnRedV2.Dao;

 

 
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.SpringLearnRedV2.Model.Usuario;

 

public interface Usuario_Dao extends JpaRepository<Usuario , Integer>{

	 //List<Usuario> findByCorreo_U(String Correo_U);
	 Optional<Usuario> findByCorreo(String correo);
	///Usuario updatemodCreadorById(boolean creadror, int idusario); 
	
	
	
}

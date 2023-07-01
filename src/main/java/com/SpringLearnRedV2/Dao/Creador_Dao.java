package com.SpringLearnRedV2.Dao;

 
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringLearnRedV2.Model.CreadorU;
 
 
public interface Creador_Dao  extends JpaRepository<CreadorU, Integer>{

	Optional<CreadorU> findByUsuario_id(Integer usuario_id);
}

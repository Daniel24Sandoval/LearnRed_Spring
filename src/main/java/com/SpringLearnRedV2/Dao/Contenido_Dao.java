package com.SpringLearnRedV2.Dao;

 

 
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 
 

import com.SpringLearnRedV2.Model.Contenido;
import com.SpringLearnRedV2.Model.Curso;
 
 
  
 
 
public interface Contenido_Dao extends JpaRepository<Contenido, Long> {
	 List<Contenido> findByid(Integer id);
	 List<Contenido> findAllById(Integer id);

}


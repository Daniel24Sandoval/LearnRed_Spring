package com.SpringLearnRedV2.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringLearnRedV2.Model.Seccion_Curso;

public interface Secciones_Dao extends JpaRepository<Seccion_Curso, Integer>{

	List<Seccion_Curso> findByCursoId(Integer curso_id);
	 

}

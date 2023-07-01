package com.SpringLearnRedV2.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringLearnRedV2.Model.Curso;

public interface Curso_Dao extends JpaRepository<Curso, Integer >{

	 List<Curso> findAllById(Integer creadorU_id);
	 List<Curso> findAllByCreadorU_id(Integer creadorU_id);
 
}

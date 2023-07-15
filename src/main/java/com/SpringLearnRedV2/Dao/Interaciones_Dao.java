package com.SpringLearnRedV2.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringLearnRedV2.Model.Interacciones;

public interface Interaciones_Dao extends JpaRepository<Interacciones, Integer> {
	 public List<Interacciones> findAllByUsuarioId(int id);
}

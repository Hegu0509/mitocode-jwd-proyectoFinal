package com.mitocode.service;

import java.util.List;

import com.mitocode.entities.Categoria;

public interface CategoriaService {
	List<Categoria> getAll();
	
	Categoria findById(Long CategoriaId);
	
	Long create(Categoria CategoriaDetalle);
	
	void update(Long CategoriaId, Categoria CategoriaDetalle);
	
	void delete(Long CategoriaId);
}

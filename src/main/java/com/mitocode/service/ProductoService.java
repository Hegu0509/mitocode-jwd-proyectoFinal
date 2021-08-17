package com.mitocode.service;

import java.util.List;

import com.mitocode.entities.Producto;

public interface ProductoService {
	List<Producto> getAll();
	
	Producto findById(Long ProductoId);
	
	Long create(Producto ProductoDetalle);
	
	void update(Long ProductoId, Producto ProductoDetalle);
	
	void delete(Long ProductoId);
	

}

package com.mitocode.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.entities.Categoria;
import com.mitocode.entities.Producto;
import com.mitocode.repository.CategoriaRepository;
import com.mitocode.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> getAll() {
		List<Categoria> categorias= new ArrayList<>();
		categoriaRepository.findAll().forEach(categorias::add);
		return categorias;
	}

	@Override
	public Categoria findById(Long CategoriaId) {
		Optional<Categoria> categoria = Optional.ofNullable(categoriaRepository.findById(CategoriaId)
				.orElseThrow(()-> new RuntimeException("Categoria no encontrada")));
		return categoria.get();
	}

	@Override
	public Long create(Categoria CategoriaDetalle) {
		categoriaRepository.save(CategoriaDetalle);
		return CategoriaDetalle.getId();
	}

	@Override
	public void update(Long CategoriaId, Categoria CategoriaDetalle) {
		Categoria categoriaActual = this.findById(CategoriaId);
		categoriaActual.setNombreCategoria(CategoriaDetalle.getNombreCategoria());
		
		categoriaRepository.save(categoriaActual);
		
	}

	@Override
	public void delete(Long CategoriaId) {
		categoriaRepository.deleteById(CategoriaId);
		
	}

}

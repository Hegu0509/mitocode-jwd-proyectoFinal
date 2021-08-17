package com.mitocode.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.entities.Producto;
import com.mitocode.repository.ProductoRepository;
import com.mitocode.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<Producto> getAll() {
		List<Producto> productos= new ArrayList<>();
		productoRepository.findAll().forEach(productos::add);
		return productos;
	}

	@Override
	public Producto findById(Long ProductoId) {
		Optional<Producto> producto = Optional.ofNullable(productoRepository.findById(ProductoId)
				.orElseThrow(()-> new RuntimeException("Producto no encontrado")));
		return producto.get();
	}

	@Override
	public Long create(Producto ProductoDetalle) {
		productoRepository.save(ProductoDetalle);
		return ProductoDetalle.getId();
	}

	@Override
	public void update(Long ProductoId, Producto ProductoDetalle) {
		Producto productoActual = this.findById(ProductoId);
		productoActual.setNombreProducto(ProductoDetalle.getNombreProducto());
		productoActual.setDescripcionProducto(ProductoDetalle.getDescripcionProducto());
		productoActual.setCantidadProducto(ProductoDetalle.getCantidadProducto());
		productoActual.setPrecioProducto(ProductoDetalle.getPrecioProducto());
		productoActual.setCategoria(ProductoDetalle.getCategoria());
		
		productoRepository.save(productoActual);
		
	}

	@Override
	public void delete(Long ProductoId) {
		productoRepository.deleteById(ProductoId);
	}

}

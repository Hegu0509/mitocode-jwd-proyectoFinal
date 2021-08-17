package com.mitocode.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre_categoria", nullable = false, columnDefinition = "TEXT")
	private String nombreCategoria;
	
	@OneToMany(
			mappedBy = "categoria",
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
			fetch = FetchType.LAZY
	)
	private List<Producto> productos = new ArrayList<>();
	
	
	public Categoria() {
		super();
	}

	public Categoria(String nombreCategoria) {
		super();
		this.nombreCategoria = nombreCategoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombreCategoria=" + nombreCategoria + ", productos=" + productos + "]";
	}
	

}

package com.mitocode.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nombre_producto", nullable = false, columnDefinition = "TEXT")
	private String nombreProducto;

	@Column(name = "descripcion_producto", nullable = false, columnDefinition = "TEXT")
	private String descripcionProducto;

	@Column(name = "cantidad_producto", nullable = false)
	private Integer cantidadProducto;

	@Column(name = "precio_producto", nullable = false)
	private Double precioProducto;
	
	@ManyToOne
	@JoinColumn(
			name="id_categoria", 
			nullable = false, 
			referencedColumnName = "id",
			foreignKey = @ForeignKey(name="producto_categoria_fk")
	)
	private Categoria categoria;

	public Producto() {
		super();
	}

	public Producto(String nombreProducto, String descripcionProducto, Integer cantidadProducto,
			Double precioProducto) {
		super();
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.cantidadProducto = cantidadProducto;
		this.precioProducto = precioProducto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public Integer getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public Double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombreProducto=" + nombreProducto + ", descripcionProducto="
				+ descripcionProducto + ", cantidadProducto=" + cantidadProducto + ", precioProducto=" + precioProducto
				+ ", categoria=" + categoria + "]";
	}

	
}

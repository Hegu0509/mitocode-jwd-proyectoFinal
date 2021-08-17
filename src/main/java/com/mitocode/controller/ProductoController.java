package com.mitocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mitocode.entities.Producto;
import com.mitocode.service.CategoriaService;
import com.mitocode.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/show/{id}")
	public String showSingleProducto(@PathVariable("id") Long productoId, Model model) {
		Producto producto=productoService.findById(productoId);
		model.addAttribute("producto", producto);
		return "productos/showById";
	}
	
	@GetMapping("/create")
	public String newProductoForm(Model model) {
		model.addAttribute("producto", new Producto());
		model.addAttribute("categorias", categoriaService.getAll());
		return "productos/new";
	}
	
	@PostMapping
	public String saveNewProducto(Producto producto) {
		long id=productoService.create(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/{id}")
	public String editProductoForm(@PathVariable("id") Long productoId, Model model) {
		Producto producto=productoService.findById(productoId);
		model.addAttribute("categorias", categoriaService.getAll());
		model.addAttribute("producto", producto);
		return "productos/editProducto";
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping
	public String showAllProductos(Model model) {
		model.addAttribute("productos", productoService.getAll());
		model.addAttribute("categorias", categoriaService.getAll());
		return "index";
	}
	
	@PostMapping("/{id}")
	public String updateProducto(@PathVariable("id") Long productoId, Producto producto ) {
		productoService.update(productoId, producto);
		return "redirect:/productos";
	}
	
	@PostMapping("/delete/{productoId}")
	public String deleteProducto(@PathVariable("id") Long productoId) {
		productoService.delete(productoId);
		return "redirect:/productos";
	}
}

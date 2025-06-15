package com.example.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.shop.entities.Categoria;
import com.example.shop.entities.Producto;
import com.example.shop.services.CategoriaService;
import com.example.shop.services.ProductoService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/admin/productos")
public class AdminProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarProductos(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Producto> productosPage = productoService.listarProductosPaginados(pageable);
        model.addAttribute("productos", productosPage.getContent());
        model.addAttribute("productosPage", productosPage);
        model.addAttribute("paginaActual", page);
        return "admin-productos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        Producto nuevoProducto = new Producto();
        nuevoProducto.setCategoria(new Categoria());
        model.addAttribute("producto", nuevoProducto);
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "producto_form";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.guardarProducto(producto);
        return "redirect:/admin/productos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("producto", productoService.obtenerProductoPorId(id));
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "producto_form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "redirect:/admin-productos";
    }
}

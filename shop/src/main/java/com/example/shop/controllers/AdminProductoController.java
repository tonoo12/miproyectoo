package com.example.shop.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;

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
    public String guardarProducto(@ModelAttribute Producto producto,
            @RequestParam("imagen") MultipartFile imagen,
            @RequestParam("imagenActual") String imagenActual) throws IOException {

        if (!imagen.isEmpty()) {
            // Ruta absoluta hacia la carpeta imagenes dentro del proyecto 'shop'
            String rutaBase = System.getProperty("user.dir") + File.separator + "shop" + File.separator + "imagenes";
            Path rutaImagenes = Paths.get(rutaBase);

            // Crear carpeta si no existe
            if (!Files.exists(rutaImagenes)) {
                Files.createDirectories(rutaImagenes);
            }

            // Generar nombre único y guardar archivo
            String nombreImagen = UUID.randomUUID() + "_" + imagen.getOriginalFilename();
            Files.write(rutaImagenes.resolve(nombreImagen), imagen.getBytes());

            producto.setImagenProducto(nombreImagen);
        } else {
            producto.setImagenProducto(imagenActual);
        }

        productoService.guardarProducto(producto);
        return "redirect:/admin/productos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Producto producto = productoService.obtenerProductoPorId(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "producto_form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "redirect:/admin/productos";
    }
}

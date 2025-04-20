package com.example.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shop.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar productos por nombre o categoría
    
}
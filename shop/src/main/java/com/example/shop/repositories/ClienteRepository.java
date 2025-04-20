package com.example.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shop.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar clientes por nombre o email

}
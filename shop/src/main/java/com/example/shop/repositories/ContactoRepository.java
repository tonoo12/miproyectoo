package com.example.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shop.entities.contacto;

public interface ContactoRepository extends JpaRepository<contacto, Long>{
    
}

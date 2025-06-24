package com.example.shop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shop.entities.TallaProducto;

public interface TallaProductoRepository extends JpaRepository<TallaProducto, Long>{
    List<TallaProducto> findByProductoId(Long idProducto);
}

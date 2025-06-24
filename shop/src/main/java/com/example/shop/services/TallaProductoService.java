package com.example.shop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.entities.TallaProducto;
import com.example.shop.repositories.TallaProductoRepository;

@Service
public class TallaProductoService {
    
    @Autowired
    private TallaProductoRepository tallaProductoRepository;

    public List<TallaProducto> listarTallaPorProductos(Long idProducto){
        return tallaProductoRepository.findByProductoId(idProducto);
    }

    public void guardarTallaProducto(TallaProducto tallaProducto){
        tallaProductoRepository.save(tallaProducto);
    }

    public Optional<TallaProducto> obtenerPorTallaYProducto(Long idProducto, Long idTalla){
        return tallaProductoRepository.findByProductoId(idProducto).stream()
        .filter(tp -> tp.getTalla().getIdTalla().equals(idTalla))
        .findFirst();
    }

}

package com.example.shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.entities.Talla;
import com.example.shop.repositories.TallaRepository;

@Service
public class TallaService {
    
    @Autowired
    private TallaRepository tallaRepository;

    public List<Talla> listarTallas(){
        return tallaRepository.findAll();
    }
}

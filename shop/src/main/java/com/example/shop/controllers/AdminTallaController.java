package com.example.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shop.services.TallaService;

@Controller
@RequestMapping("/admin/tallas")
public class AdminTallaController {
    
    @Autowired
    private TallaService tallaService;

    @GetMapping
    public String listarTallas(Model model){
        model.addAttribute("tallas", tallaService.listarTallas());
        return "admin-tallas";
    }

}

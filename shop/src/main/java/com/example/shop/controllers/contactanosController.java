package com.example.shop.controllers;

import com.example.shop.entities.contacto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class contactanosController {

    @GetMapping("/contactanos")
    public String mostrarFormularioContacto(Model model) {
        model.addAttribute("contacto", new contacto());
        return "contactanos";
    }

    @PostMapping("/contactanos")
    public String procesarFormularioContacto(@ModelAttribute("contacto") contacto contacto) {
        // Aquí puedes guardar los datos, enviar email, etc.
        System.out.println("Nombre: " + contacto.getNombre());
        System.out.println("Correo: " + contacto.getCorreo());
        System.out.println("Mensaje: " + contacto.getMensaje());
        return "redirect:/contactanos?exito";
    }
}


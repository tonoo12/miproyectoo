package com.example.shop.controller;

import com.example.shop.entities.Pedido;
import com.example.shop.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Controller
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Mostrar formulario de envío (si tienes una vista directa para mostrarlo)
    @GetMapping("/modalPagoEntrega")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "formulario_pago"; // Asegúrate que exista formulario_pago.html si accedes directamente
    }

    // Recibe los datos del formulario
    @PostMapping("/procesar_pago")
    public String procesarPago(@ModelAttribute("pedido") Pedido pedido) {
        // Asignar fecha del pedido automáticamente
        pedido.setFechaPedido(LocalDate.now());

        // Guardar en la base de datos
        pedidoRepository.save(pedido);

        // Redirigir a página de confirmación
        return "redirect:/confirmacion";
    }

    // Página de confirmación
    @GetMapping("/confirmacion")
    public String mostrarConfirmacion() {
        return "confirmacion"; // Debes tener una vista confirmacion.html
    }
}

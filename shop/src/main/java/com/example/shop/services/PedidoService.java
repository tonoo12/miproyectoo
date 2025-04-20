package com.example.shop.services;

import com.example.shop.entities.Pedido;
import com.example.shop.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Obtener todos los pedidos
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    // Obtener pedido por ID
    public Optional<Pedido> obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    // Crear un nuevo pedido
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Actualizar un pedido
    public Pedido actualizarPedido(Long id, Pedido pedidoActualizado) {
        if (pedidoRepository.existsById(id)) {
            pedidoActualizado.setIdPedido(id); // Establecer el ID del pedido a actualizar
            return pedidoRepository.save(pedidoActualizado);
        }
        return null; // En caso de que no exista el pedido
    }

    // Eliminar un pedido
    public boolean eliminarPedido(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

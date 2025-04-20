package com.example.shop.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long idCliente;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "email")
    private String email;

    @Column(name = "direccion")
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
}
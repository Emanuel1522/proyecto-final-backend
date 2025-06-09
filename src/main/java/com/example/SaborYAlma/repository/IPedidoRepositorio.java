package com.example.SaborYAlma.repository;

import com.example.SaborYAlma.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepositorio extends JpaRepository<Pedido, Integer> {
}

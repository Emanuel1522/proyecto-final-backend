package com.example.SaborYAlma.repository;

import com.example.SaborYAlma.models.DetallesPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetallesPedidoRepositorio extends JpaRepository<DetallesPedido, Integer> {
}

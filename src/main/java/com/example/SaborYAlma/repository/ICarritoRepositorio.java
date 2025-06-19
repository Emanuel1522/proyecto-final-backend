package com.example.SaborYAlma.repository;

import com.example.SaborYAlma.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarritoRepositorio extends JpaRepository<Carrito, Integer> {
}

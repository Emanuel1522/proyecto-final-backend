package com.example.SaborYAlma.repository;

import com.example.SaborYAlma.models.CarritoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarritoItemRepositorio extends JpaRepository<CarritoItem, Integer> {
}

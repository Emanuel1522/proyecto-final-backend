package com.example.SaborYAlma.repository;

import com.example.SaborYAlma.model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlatoRepositorio extends JpaRepository<Plato, Integer> {
}

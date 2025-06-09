package com.example.SaborYAlma.repository;

import com.example.SaborYAlma.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepositorio extends JpaRepository<Cliente, Integer> {
}

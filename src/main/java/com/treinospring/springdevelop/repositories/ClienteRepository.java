package com.treinospring.springdevelop.repositories;

import com.treinospring.springdevelop.domain.Categoria;
import com.treinospring.springdevelop.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}

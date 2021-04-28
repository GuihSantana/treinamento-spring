package com.treinospring.springdevelop.repositories;

import com.treinospring.springdevelop.domain.Cidade;
import com.treinospring.springdevelop.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
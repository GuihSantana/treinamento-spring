package com.treinospring.springdevelop.services;

import com.treinospring.springdevelop.domain.Categoria;
import com.treinospring.springdevelop.repositories.CategoriaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repositorioCategoria;


    public Categoria buscar(Integer id){
       Optional<Categoria> obj = repositorioCategoria.findById(id);
       return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + Categoria.class.getName(), "Id: "+ id));
    }

}

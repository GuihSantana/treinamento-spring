package com.treinospring.springdevelop.resources;

import com.treinospring.springdevelop.domain.Categoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listarCategorias(){

        Categoria inform = new Categoria(1, "Informatica");
        Categoria escrit = new Categoria(2, "Escritório");

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(inform);
        categorias.add(escrit);

        return categorias;

    }
}

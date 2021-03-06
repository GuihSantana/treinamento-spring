package com.treinospring.springdevelop.resources;

import com.treinospring.springdevelop.domain.Categoria;
import com.treinospring.springdevelop.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> obterCategoria(@PathVariable Integer id){
        Categoria categoriaBD = categoriaService.buscar(id);
        return ResponseEntity.ok().body(categoriaBD);
    }
}

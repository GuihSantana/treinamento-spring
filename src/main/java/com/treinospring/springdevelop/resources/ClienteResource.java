package com.treinospring.springdevelop.resources;

import com.treinospring.springdevelop.domain.Cliente;
import com.treinospring.springdevelop.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> obterCategoria(@PathVariable Integer id) {
        Cliente clienteBD = clienteService.buscar(id);
        return ResponseEntity.ok().body(clienteBD);
    }
}

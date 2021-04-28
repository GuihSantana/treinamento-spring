package com.treinospring.springdevelop.services;

import com.treinospring.springdevelop.domain.Cliente;
import com.treinospring.springdevelop.repositories.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente buscar(Integer id){
       Optional<Cliente> obj = clienteRepository.findById(id);
       return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + Cliente.class.getName(), "Id: "+ id));
    }

}

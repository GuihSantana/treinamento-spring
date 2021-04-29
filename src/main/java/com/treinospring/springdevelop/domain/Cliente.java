package com.treinospring.springdevelop.domain;

import com.treinospring.springdevelop.enums.TipoCliente;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipoCliente;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipoCliente) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipoCliente = tipoCliente.getCod();
    }

    public Integer getId() {
        return id;
    }

    public Cliente setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Cliente setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public Cliente setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
        return this;
    }


    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public Cliente setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
        return this;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public Cliente setTelefones(Set<String> telefones) {
        this.telefones = telefones;
        return this;
    }

    public TipoCliente getTipoCliente() throws Exception {
        return TipoCliente.toEnum(tipoCliente);
    }

    public Cliente setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente.getCod();
        return this;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }


    public Cliente setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

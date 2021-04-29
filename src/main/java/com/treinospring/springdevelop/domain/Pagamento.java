package com.treinospring.springdevelop.domain;

import com.treinospring.springdevelop.enums.EstadoPagamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private Integer estadoPagamento;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(Integer id, EstadoPagamento estadoPagamento, Pedido pedido) {
        this.id = id;
        this.estadoPagamento = estadoPagamento.getCod();
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public Pagamento setId(Integer id) {
        this.id = id;
        return this;
    }

    public EstadoPagamento getEstadoPagamento() {
        return EstadoPagamento.toEnum(estadoPagamento);
    }

    public Pagamento setEstadoPagamento(EstadoPagamento estadoPagamento) {
        this.estadoPagamento = estadoPagamento.getCod();
        return this;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Pagamento setPedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return id.equals(pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package com.treinospring.springdevelop.domain;

import com.treinospring.springdevelop.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagamentoComBoleto extends Pagamento {
    private static final long serialVersionUID = 1L;

    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto() {

    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id, estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public PagamentoComBoleto setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
        return this;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public PagamentoComBoleto setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
        return this;
    }


}

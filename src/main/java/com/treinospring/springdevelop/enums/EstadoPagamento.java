package com.treinospring.springdevelop.enums;

public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int cod;
    private String descricao;

    EstadoPagamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamento toEnum(Integer cod){
        if(cod ==null){
            return null;
        }
        for(EstadoPagamento estadoPagamento : EstadoPagamento.values()){
            if (cod.equals(estadoPagamento.getCod())){
                return estadoPagamento;
            }
        }
        throw new IllegalArgumentException("Id invalido: " + cod);
    }


}

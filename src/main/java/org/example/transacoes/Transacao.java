package org.example.transacoes;

import java.util.Date;

public class Transacao {
    private double valor;
    public Date data;

    public Transacao(double valor){
        this.valor = valor;
        this.data = new Date();
    }

    public Date getData() {
        return data;
    }
}

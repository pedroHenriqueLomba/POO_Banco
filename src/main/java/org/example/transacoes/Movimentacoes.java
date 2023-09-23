package org.example.transacoes;

public interface Movimentacoes {
    public void depositar(double valor);
    public void sacar(double valor) throws Exception;
}

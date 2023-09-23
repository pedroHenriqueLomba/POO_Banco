package org.example.investimentos;

import java.util.Date;

public interface Investimento {
    public void realizarAplicacao(double rendimento, double valorAplicado, Date dataInicial, Date dataFinal);
    public void realizarFinanciamento(double juros, double valorFinanciado, Date inicioPagamento, Date finalPagamento);
}

package org.example.investimentos;

import java.time.LocalDate;
import java.util.Date;

public class Financiamento {
    private double juros;
    private double valorFinanciado;
    private Date inicioPagamento;
    private Date finalPagamento;

    public Financiamento(double juros, double valorFinanciado, Date inicioPagamento, Date finalPagamento) {
        this.juros = juros;
        this.valorFinanciado = valorFinanciado;
        this.inicioPagamento = inicioPagamento;
        this.finalPagamento = finalPagamento;
    }

    public double calculaValorTotal(){
        long dias = (finalPagamento.getTime() - inicioPagamento.getTime()) / (24 * 60 * 60 * 1000);

        return valorFinanciado * Math.pow(1 + (juros / 100), dias / 365.0);
    }

    public double calculaValorPagoAteHoje(){
        double valorTotalFinanciamento = this.calculaValorTotal();
        LocalDate dataHoje = LocalDate.now();

        float mesesPagos = ((dataHoje.getYear() * 12 + dataHoje.getMonthValue()) - (inicioPagamento.getMonth() + inicioPagamento.getYear() * 12));
        float mesesTotais = ((finalPagamento.getYear() * 12 + finalPagamento.getMonth() - (inicioPagamento.getMonth() + inicioPagamento.getYear() * 12)));

        float proporcaoPaga = mesesPagos / mesesTotais;

        return valorTotalFinanciamento * proporcaoPaga;
    }
}

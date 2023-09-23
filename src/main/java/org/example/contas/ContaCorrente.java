package org.example.contas;

import org.example.investimentos.Aplicacao;
import org.example.investimentos.Investimento;
import org.example.transacoes.Deposito;
import org.example.transacoes.Saque;
import org.example.transacoes.Movimentacoes;
import org.example.usuarios.PessoaFisica;
import org.example.usuarios.PessoaJuridica;

import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente extends Conta implements Investimento, Movimentacoes {
    private ArrayList<Aplicacao> aplicacoes;
    public ContaCorrente(int numero, double saldo){
        super(numero, saldo);
        this.tipoConta = TipoConta.CORRENTE;
    };
    public ContaCorrente(int numero, double saldo, PessoaJuridica titular1, TipoConta tipoConta){
        super(numero, saldo, titular1, tipoConta);
        this.tipoConta = TipoConta.CORRENTE;
    };
    public ContaCorrente(int numero, double saldo, PessoaFisica titular1, TipoConta tipoConta){
        super(numero, saldo, titular1, tipoConta);
        this.tipoConta = TipoConta.CORRENTE;
    };
    public ContaCorrente(int numero, double saldo, PessoaFisica titular1, PessoaFisica titular2, Vinculo vinculo){
        super(numero, saldo, titular1, titular2, vinculo);
        this.tipoConta = TipoConta.CORRENTE;
    };
    @Override
    public void realizarAplicacao(double rendimento, double valorAplicado, Date dataInicial, Date dataFinal) {
        if(this.aplicacoes == null)
            this.aplicacoes = new ArrayList<Aplicacao>();
        this.aplicacoes.add(new Aplicacao(rendimento, valorAplicado, dataInicial, dataFinal));
    }

    @Override
    public void realizarFinanciamento(double juros, double valorFinanciado, Date inicioPagamento, Date finalPagamento) {
        if(this.aplicacoes == null)
            this.aplicacoes = new ArrayList<Aplicacao>();
        this.aplicacoes.add(new Aplicacao(juros, valorFinanciado, inicioPagamento, finalPagamento));
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        this.extrato.adicionarDeposito(new Deposito(valor));
    }

    @Override
    public void sacar(double valor) throws Exception {
        if (saldo < valor)
            throw new Exception("Saldo insuficiente");
        this.saldo -= valor;
        this.extrato.adicionarSaque(new Saque(valor));
    }
}

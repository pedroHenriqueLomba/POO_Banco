package org.example.contas;

import org.example.transacoes.Deposito;
import org.example.transacoes.Saque;
import org.example.transacoes.Movimentacoes;
import org.example.usuarios.PessoaFisica;
import org.example.usuarios.PessoaJuridica;

public class ContaPoupanca extends Conta implements Movimentacoes {
    public ContaPoupanca(int numero, double saldo) throws Exception {
        super(numero, saldo);
        this.tipoConta = TipoConta.POUPANCA;
        this.verificaSaldoMinimo(saldo);
    }
    public ContaPoupanca(int numero, double saldo, PessoaJuridica titular1, TipoConta tipoConta) throws Exception {
        super(numero, saldo, titular1, tipoConta);
        this.tipoConta = TipoConta.POUPANCA;
        this.verificaSaldoMinimo(saldo);
    };
    public ContaPoupanca(int numero, double saldo, PessoaFisica titular1, TipoConta tipoConta) throws Exception {
        super(numero, saldo, titular1, tipoConta);
        this.tipoConta = TipoConta.POUPANCA;
        this.verificaSaldoMinimo(saldo);
    };
    public ContaPoupanca(int numero, double saldo, PessoaFisica titular1, PessoaFisica titular2, Vinculo vinculo) throws Exception {
        super(numero, saldo, titular1, titular2, vinculo);
        this.tipoConta = TipoConta.POUPANCA;
        this.verificaSaldoMinimo(saldo);
    };

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

    private void verificaSaldoMinimo(double saldo) throws Exception {
        if(saldo < 50)
            throw new Exception("Saldo insuficiente para abrir a conta");
    }
}


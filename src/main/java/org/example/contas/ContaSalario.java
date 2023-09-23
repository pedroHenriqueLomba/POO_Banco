package org.example.contas;

import org.example.transacoes.Deposito;
import org.example.transacoes.Saque;
import org.example.transacoes.Movimentacoes;
import org.example.usuarios.PessoaFisica;

public class ContaSalario extends Conta implements Movimentacoes {
    public ContaSalario(int numero, double saldo) {
        super(numero, saldo);
        this.tipoConta = TipoConta.SALARIO;
    }
    public ContaSalario(int numero, double saldo, PessoaFisica titular1, TipoConta tipoConta){
        super(numero, saldo, titular1, tipoConta);
        this.tipoConta = TipoConta.SALARIO;
    };
    public ContaSalario(int numero, double saldo, PessoaFisica titular1, PessoaFisica titular2, Vinculo vinculo){
        super(numero, saldo, titular1, titular2, vinculo);
        this.tipoConta = TipoConta.SALARIO;
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
}

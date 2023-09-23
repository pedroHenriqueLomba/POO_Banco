package org.example.contas;

import org.example.usuarios.Pessoa;
import org.example.usuarios.PessoaFisica;
import org.example.usuarios.PessoaJuridica;

import java.util.List;

public abstract class Conta {
    protected int numero;
    protected double saldo;
    protected Vinculo vinculo;
    protected Pessoa titular1;
    protected Pessoa titular2;
    public Extrato extrato;
    protected TipoConta tipoConta;

    public Conta(int numero, double saldo, PessoaFisica titular1, TipoConta tipoConta) {
        this.numero = numero;
        this.saldo = saldo;
        this.titular1 = titular1;
        this.extrato = new Extrato();
        this.tipoConta = tipoConta;
    }

    public Conta(int numero, double saldo, PessoaFisica titular1, PessoaFisica titular2, Vinculo vinculo){
        this.numero = numero;
        this.vinculo = vinculo;
        this.saldo = saldo;
        this.extrato = new Extrato();
        this.titular1 = titular1;
        this.titular2 = titular2;
    }
    public Conta(int numero, double saldo, PessoaJuridica titular1, TipoConta tipoConta) {
        this.numero = numero;
        this.saldo = saldo;
        this.titular1 = titular1;
        this.extrato = new Extrato();
        this.tipoConta = tipoConta;
    }

    public Conta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
        this.extrato = new Extrato();
    }
    public TipoConta getTipo() {
        return this.tipoConta;
    }
    public double getSaldo() {
        return saldo;
    }
}

package org.example.usuarios;

public class PessoaJuridica extends Pessoa{
    public int cnpj;

    public PessoaJuridica(String nome, int cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }
}

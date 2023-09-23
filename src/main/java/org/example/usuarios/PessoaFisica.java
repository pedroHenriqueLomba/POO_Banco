package org.example.usuarios;

import java.util.Date;

public class PessoaFisica extends Pessoa{
    public Date dataAniversario;
    public Integer cpf;

    public PessoaFisica(String nome, Date dataAniversario, Integer cpf) {
        super(nome);
        this.dataAniversario = dataAniversario;
        this.cpf = cpf;
    }
}

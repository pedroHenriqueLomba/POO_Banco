package org.example.contas;

import org.example.transacoes.Deposito;
import org.example.transacoes.Saque;
import org.example.transacoes.Transacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Extrato {
    ArrayList<Deposito> depositos;
    ArrayList<Saque> saques;

    public void adicionarDeposito(Deposito deposito) {
        if(this.depositos == null)
            this.depositos = new ArrayList<Deposito>();
        this.depositos.add(deposito);
    }

    public void adicionarSaque(Saque saque) {
        if(this.saques == null)
            this.saques = new ArrayList<Saque>();
        this.saques.add(saque);
    }

    public List<Transacao> getExtrato() {
        List<Transacao> transacoes = new ArrayList<>();

        if (depositos != null) {
            transacoes.addAll(depositos);
        }

        if (saques != null) {
            transacoes.addAll(saques);
        }

        return transacoes;
    }

    public List<Transacao> getExtratoPorPeriodo(Date primeiroDia, Date ultimoDia){
        List<Transacao> transacoes = new ArrayList<>();

        if (depositos != null) {
            for (Deposito deposito:
                 this.depositos) {
                if(deposito.getData().compareTo(primeiroDia) >= 0 && deposito.getData().compareTo(ultimoDia) <= 0)
                    transacoes.add(deposito);
            }
        }

        if (saques != null) {
            for (Saque saque:
                    this.saques) {
                if(saque.getData().compareTo(primeiroDia) >= 0 && saque.getData().compareTo(ultimoDia) <= 0)
                    transacoes.add(saque);
            }
        }

        return transacoes;
    }
}

package org.example.services;

import org.example.contas.Conta;
import org.example.contas.TipoConta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ValidaOperacaoService {
    private static final List<TipoConta> podeFinanciar = List.of(TipoConta.CORRENTE);
    private static final List<TipoConta> podeAplicar = List.of(TipoConta.CORRENTE);
    private static final List<TipoConta> podeSacar = List.of(TipoConta.CORRENTE, TipoConta.SALARIO, TipoConta.POUPANCA);
    private static final List<TipoConta> podeDepositar = List.of(TipoConta.CORRENTE, TipoConta.SALARIO, TipoConta.POUPANCA);

    public static void verificaSePodeFinanciar(@NotNull Conta conta) throws Exception {
        if(! podeFinanciar.contains(conta.getTipo()))
            throw new Exception("Essa conta não pode realiza esta ação");
    }
    public static void verificaSePodeAplicar(@NotNull Conta conta) throws Exception {
        if(! podeAplicar.contains(conta.getTipo()))
            throw new Exception("Essa conta não pode realiza esta ação");
    }
    public static void verificaSePodeSacar(@NotNull Conta conta) throws Exception {
        if(! podeSacar.contains(conta.getTipo()))
            throw new Exception("Essa conta não pode realiza esta ação");
    }
    public static void verificaSePodeDepositar(@NotNull Conta conta) throws Exception {
        if(! podeDepositar.contains(conta.getTipo()))
            throw new Exception("Essa conta não pode realiza esta ação");
    }
}

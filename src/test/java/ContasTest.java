import org.example.contas.*;
import org.example.transacoes.Transacao;
import org.example.usuarios.PessoaFisica;
import org.example.usuarios.PessoaJuridica;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ContasTest {
    @Test
    public void deveCriarContaConjunta() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataPai = sdf.parse("11/03/1982");
        PessoaFisica pai = new PessoaFisica("Rodolfo", new Date(dataPai.getTime()), 123456);
        Date dataFilho = sdf.parse("14/11/2002");
        PessoaFisica filho = new PessoaFisica("Pedro", new Date(dataFilho.getTime()), 123456);

        ContaPoupanca contaPoupanca = new ContaPoupanca(5621, 500, pai, filho, Vinculo.FILIACAO);
    }
    @Test
    public void deveCriarContaNormal() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataPai = sdf.parse("11/03/1982");
        PessoaFisica pessoa = new PessoaFisica("Rodolfo", new Date(dataPai.getTime()), 123456);

        ContaPoupanca contaPoupanca = new ContaPoupanca(5621, 500);
    }
    @Test
    public void deveCriarContaComPessoaJuridica() throws Exception{
        PessoaJuridica pessoaJuridica = new PessoaJuridica("Pedro", 123456);
        ContaPoupanca contaPoupanca = new ContaPoupanca(5465, 500, pessoaJuridica, TipoConta.POUPANCA);
    }

    @Test
    public void deveImpedirCriacaoDeContaPoupanca(){
        try {
            PessoaJuridica pessoaJuridica = new PessoaJuridica("Pedro", 123456);
            ContaPoupanca contaPoupanca = new ContaPoupanca(5465, 20, pessoaJuridica, TipoConta.POUPANCA);
            Assertions.fail();
        } catch (Throwable throwable) {
            Assertions.assertEquals("Saldo insuficiente para abrir a conta", throwable.getMessage());
        }
    }
    @Test
    public void deveRetornarExtratoTotal() throws Exception {
        PessoaJuridica pessoaJuridica = new PessoaJuridica("Pedro", 123456);
        ContaPoupanca contaPoupanca = new ContaPoupanca(5465, 500, pessoaJuridica, TipoConta.POUPANCA);
        contaPoupanca.depositar(500);
        contaPoupanca.sacar(120);
        List<Transacao> transacoes = contaPoupanca.extrato.getExtrato();
        Assertions.assertEquals(2, transacoes.size());
    }
    @Test
    public void deveRetornarExtratoPorPeriodo() throws Exception {
        PessoaJuridica pessoaJuridica = new PessoaJuridica("Pedro", 123456);
        ContaPoupanca contaPoupanca = new ContaPoupanca(5465, 500, pessoaJuridica, TipoConta.POUPANCA);
        contaPoupanca.depositar(500);
        contaPoupanca.sacar(120);
        List<Transacao> transacoes = contaPoupanca.extrato.getExtratoPorPeriodo(new Date(123),new Date(500));
        Assertions.assertEquals(0, transacoes.size());

        transacoes = contaPoupanca.extrato.getExtratoPorPeriodo(new Date(1),new Date());
        Assertions.assertEquals(2, transacoes.size());
    }
}
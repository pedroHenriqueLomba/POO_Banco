import org.example.investimentos.Aplicacao;
import org.example.investimentos.Financiamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class InvestimentosTest {
    @Test
    public void deveRetornarValorTotalDoFinanciamento() {
        Financiamento financiamento = new Financiamento(1, 1000, new Date(2022, 8, 1), new Date(2024, 8, 1));

        Assertions.assertEquals(1010.0, financiamento.calculaValorTotal(), 0.01);
    }

    @Test
    public void deveRetornarValorPagoAteHojeDoFinanciamento() {
        Financiamento financiamento = new Financiamento(1, 1000, new Date(2022, 8, 1), new Date(2024, 8, 1));

        Assertions.assertEquals(552.56, financiamento.calculaValorPagoAteHoje(), 0.01);
    }

    @Test
    public void deveRetornarValorTotalDaAplicacao() throws Exception {
        Aplicacao aplicacao = new Aplicacao(1,1000,new Date(2022,8, 1), new Date(2024,8, 1));

        Assertions.assertEquals(1532.89, aplicacao.calculaMontanteFinal(), 0.01);
    }

    @Test
    public void deveRetornarValorQueAAplicacaoRendeuAteHoje() throws Exception {
        Aplicacao aplicacao = new Aplicacao(1,1000,new Date(2022,8, 1), new Date(2024,8, 1));

        Assertions.assertEquals(1275.92, aplicacao.calculaMontanteAteHoje(), 0.01);
    }
}

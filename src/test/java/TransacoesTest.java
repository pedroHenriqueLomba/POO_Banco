import org.example.contas.ContaSalario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransacoesTest {
    @Test
    public void deveAumentarSaldoParaDuzentos(){
        ContaSalario contaSalario = new ContaSalario(1065,150.00);
        contaSalario.depositar(50.00);
        Assertions.assertEquals(200, contaSalario.getSaldo());
    }

    @Test
    public void deveAbaixarSaldoParaCem() throws Exception {
        ContaSalario contaSalario = new ContaSalario(4598, 200.0);
        contaSalario.sacar(100.00);
        Assertions.assertEquals(100, contaSalario.getSaldo());
    }

    @Test
    public void deveManterSaldoEBloquearTransacao() throws Exception{
        ContaSalario contaSalario = new ContaSalario(4598, 100.0);
        try {
            contaSalario.sacar(2000.00); // Lança excessão
            Assertions.fail("Deveria ter lançado uma exceção");
        } catch (Throwable throwable) {
            Assertions.assertEquals("Saldo insuficiente", throwable.getMessage());
            Assertions.assertEquals(100, contaSalario.getSaldo());
        }
    }
}

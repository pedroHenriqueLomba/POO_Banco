package org.example.investimentos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Aplicacao {
    private double rendimento;
    private double valorAplicado;
    private Date dataInicial;
    private Date dataFinal;

    public Aplicacao(double rendimento, double valorAplicado, Date dataInicial) {
        this.rendimento = rendimento;
        this.valorAplicado = valorAplicado;
        this.dataInicial = dataInicial;
    }

    public Aplicacao(double rendimento, double valorAplicado, Date dataInicial, Date dataFinal) {
        this.rendimento = rendimento;
        this.valorAplicado = valorAplicado;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public double calculaMontanteAteHoje(){
        LocalDate dataAtual = LocalDate.now();

        Date date = new Date(dataAtual.getYear(), dataAtual.getMonthValue(), dataAtual.getDayOfMonth());

        long milissegundos = date.getTime();

        return calculaMontanteAteDataFinal(milissegundos);
    }

    public double calculaMontanteFinal() throws Exception {
        if(this.dataFinal == null)
            throw new Exception("Não existe uma data final");

        return calculaMontanteAteDataFinal(this.dataFinal.getTime());
    }

    private double calculaMontanteAteDataFinal(long dataEmMili) {
        long periodoEmMillis = dataEmMili - dataInicial.getTime();

        double anos = (double) periodoEmMillis / (1000 * 60 * 60 * 24 * 365);

        double montanteAteDataFinal = this.valorAplicado * Math.pow(1.0 + (this.rendimento / 100), anos);

        return montanteAteDataFinal;
    }

}

package org.example.services;

import java.text.DecimalFormat;

public class FormatadorService {
    public static double formataDecimal(double valor){

        DecimalFormat formato = new DecimalFormat("0.00");

        String valorFormatado = formato.format(valor);

        return Double.parseDouble(valorFormatado);
    }
}

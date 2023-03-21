package com.wpe.controle_funcionario.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class DateUtil {
    public String formataDataToString(Date data,String formato){
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        return dateFormat.format(data);
    }

    public Date formataStringToData(String data,String formato) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        return dateFormat.parse(data);
    }

    public long calculaDiferencaHora(Date dataInicial, Date dataFinal){
        long dataInicialMilissegundo = dataInicial.getTime();
        long dataFinalMilissegundo = dataFinal.getTime();

        return dataFinalMilissegundo - dataInicialMilissegundo;
    }

    public String mesPorExtenso(int mes){
        switch (mes){
            case 1:
                return "JANEIRO";
            case 2:
                return "FEVEREIRO";
            case 3:
                return "MARÇO";
            case 4:
                return "ABRIL";
            case 5:
                return "MAIO";
            case 6:
                return "JUNHO";
            case 7:
                return "JULHO";
            case 8:
                return "AGOSTO";
            case 9:
                return "SETEMBRO";
            case 10:
                return "OUTUBRO";
            case 11:
                return "NOVEMBRO";
            case 12:
                return "DEZEMBRO";
            default:
                return "MÊS INVÁLIDO";
        }
    }
}

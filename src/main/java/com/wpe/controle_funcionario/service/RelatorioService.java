package com.wpe.controle_funcionario.service;

import com.wpe.controle_funcionario.enums.LogicoEnum;
import com.wpe.controle_funcionario.enums.RelatorioEnum;
import com.wpe.controle_funcionario.util.DateUtil;
import com.wpe.controle_funcionario.util.GenericRelatorio;
import com.wpe.controle_funcionario.model.oscip.ControleFuncionario;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RelatorioService{

    @Autowired
    @Qualifier("oscipDataSource")
    DataSource dataSource;
    @Autowired
    private GenericRelatorio genericRelatorio;

    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private ControleFuncionarioService controleFuncionarioService;

    public byte[] gerarRelatorioPdf(String dataInicial,String dataFinal ) throws FileNotFoundException,
                                                                            JRException, SQLException {

        List<ControleFuncionario> registros = controleFuncionarioService.findByPeriodo(dataInicial,dataFinal);

        double totalHoraNormal = controleFuncionarioService.calculaTotalHoras(registros, LogicoEnum.NAO.getValue());
        double totalHoraExtra = controleFuncionarioService.calculaTotalHoras(registros, LogicoEnum.SIM.getValue());

        String mesReferencia = dateUtil.mesPorExtenso(Calendar.MONTH + 1) + " / " + Calendar.getInstance().getWeekYear();

        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("DATA_INICIAL", dataInicial);
        parametros.put("DATA_FINAL", dataFinal);
        parametros.put("MES_REFERENCIA", mesReferencia);
        parametros.put("TOT_HORA_NORMAL",totalHoraNormal);
        parametros.put("TOT_HORA_EXTRA",totalHoraExtra);

        return genericRelatorio.gerarRelatorioPdf(
                RelatorioEnum.FOLHA_PONTO.getDiretorio(),
                parametros,
                dataSource.getConnection());
    }
}
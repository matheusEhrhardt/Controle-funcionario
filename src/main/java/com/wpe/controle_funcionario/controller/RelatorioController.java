package com.wpe.controle_funcionario.controller;

import com.wpe.controle_funcionario.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("/folhaDePonto/{dataInicial}/{dataFinal}")
    public ResponseEntity<byte[]> getEmployeeRecordReport(@PathVariable String dataInicial,
                                                          @PathVariable String dataFinal) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("FolhaDePonto", "FolhaDePonto.pdf");

            byte[] relatorio = relatorioService.gerarRelatorioPdf(dataInicial,dataFinal);
            return new ResponseEntity<byte[]>(relatorio, headers, HttpStatus.OK);

        } catch(Exception e) {
            return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

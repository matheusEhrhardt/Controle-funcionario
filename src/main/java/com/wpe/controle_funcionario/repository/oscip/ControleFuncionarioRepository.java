package com.wpe.controle_funcionario.repository.oscip;


import com.wpe.controle_funcionario.model.oscip.ControleFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ControleFuncionarioRepository extends JpaRepository<ControleFuncionario,Integer> {

    @Query( "FROM ControleFuncionario " +
            "WHERE dataHora between to_date(:dataInicial,'yyyy-mm-dd') and to_date(:dataFinal,'yyyy-mm-dd')" +
            "ORDER BY dataHora")
    List<ControleFuncionario> findLocalizacaoExistente(String dataInicial, String dataFinal);
}

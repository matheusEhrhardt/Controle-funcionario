package com.wpe.controle_funcionario.repository.oscip;

import com.wpe.controle_funcionario.model.oscip.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao,Integer> {

    @Query("FROM Localizacao WHERE estado = :estado AND cidade = :cidade AND bairro = :bairro")
    Localizacao findLocalizacaoExistente(String estado,String cidade,String bairro);
}

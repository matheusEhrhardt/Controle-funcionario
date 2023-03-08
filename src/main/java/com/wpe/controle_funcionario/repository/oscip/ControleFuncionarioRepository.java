package com.wpe.controle_funcionario.repository.oscip;


import com.wpe.controle_funcionario.view.model.oscip.ControleFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControleFuncionarioRepository extends JpaRepository<ControleFuncionario,Integer> {
}

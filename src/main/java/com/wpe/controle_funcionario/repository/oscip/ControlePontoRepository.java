package com.marcos.mrcjewelscatalog.repository.oscip;


import com.wpe.controle_funcionario.view.model.oscip.ControlePonto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlePontoRepository extends JpaRepository<ControlePonto,Integer> {
}

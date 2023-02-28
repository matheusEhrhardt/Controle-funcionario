package com.marcos.mrcjewelscatalog.repository.oscip;

import com.wpe.controle_funcionario.view.model.oscip.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

    public Optional<Usuario> findByCodigoUsuario(String codigoUsuario);
}

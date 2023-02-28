package com.wpe.controle_funcionario.service;

import com.wpe.controle_funcionario.exception.ResourceNotFoundException;
import com.wpe.controle_funcionario.repository.oscip.UsuarioRepository;
import com.wpe.controle_funcionario.view.model.oscip.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.Optional;

@Service
public class UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;


    public Usuario cadastrar(Usuario usuario){
        Optional<Usuario> usuarioExistente = findByCodigoUsuario(usuario.getCodigoUsuario());

        if(usuarioExistente.isPresent()){
            throw new InputMismatchException("Já existe usuário cadastrado com codigo " + usuario.getCodigoUsuario());
        }

        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Usuario login(String codigoUsuario, String senha){

        Optional<Usuario> usuario =  findByCodigoUsuario(codigoUsuario);

        if(usuario.isEmpty()){
            throw new ResourceNotFoundException("Login ou senha invalido!");
        }

        Boolean acessoLiberado = encoder.matches(senha, usuario.get().getSenha());

        if(!acessoLiberado){
            throw new ResourceNotFoundException("Login ou senha invalido!");
        }

        return usuario.orElse(null);
    }

    public Optional<Usuario> findByCodigoUsuario(String codigoUsuario){
        return usuarioRepository.findByCodigoUsuario(codigoUsuario);
    }

    public Optional<Usuario> findById(Integer id){
        return usuarioRepository.findById(id);
    }
}
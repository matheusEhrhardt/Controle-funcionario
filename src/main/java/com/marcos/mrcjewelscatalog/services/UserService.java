package com.marcos.mrcjewelscatalog.services;

import com.marcos.mrcjewelscatalog.dto.UserDTO;
import com.marcos.mrcjewelscatalog.entities.Role;
import com.marcos.mrcjewelscatalog.entities.User;
import com.marcos.mrcjewelscatalog.repositories.RoleRepository;
import com.marcos.mrcjewelscatalog.repositories.UserRepository;
import com.marcos.mrcjewelscatalog.services.exceptions.ObjectNotFound;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;

    @Transactional
    public UserDTO findById(Long id){
        return new UserDTO(
                repository.findById(id).orElseThrow(()-> new ObjectNotFound("Usuário não encontrado"))) ;
    }
    @Transactional
    public UserDTO insert(UserDTO entity){
        findById(entity.getId());
        User obj = new User();
        copyDtoToEntity(entity,obj);
        return new UserDTO(repository.save(obj));
    }

    private void copyDtoToEntity(UserDTO entity, User obj) {
        obj.setName(entity.getName());
        obj.setEmail(entity.getEmail());
        obj.setPassword(entity.getPassword());

        obj.getRoles().clear();

        entity.getRolesDTO().forEach(dto ->{
            Role role = roleRepository.getReferenceById(dto.getId());
            obj.getRoles().add(role);
        });
    }
}

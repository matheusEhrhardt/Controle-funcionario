package com.marcos.mrcjewelscatalog.services;

import com.marcos.mrcjewelscatalog.entities.dto.UserDTO;
import com.marcos.mrcjewelscatalog.entities.Role;
import com.marcos.mrcjewelscatalog.entities.User;
import com.marcos.mrcjewelscatalog.repositories.RoleRepository;
import com.marcos.mrcjewelscatalog.repositories.UserRepository;
import com.marcos.mrcjewelscatalog.services.exceptions.DatabaseException;
import com.marcos.mrcjewelscatalog.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;

    @Transactional
    public UserDTO findById(Long id){
        return new UserDTO(
                repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Entity not found"))) ;
    }
    @Transactional
    public UserDTO insert(UserDTO entity){
        User obj = new User();
        copyDtoToEntity(entity,obj);
        return new UserDTO(repository.save(obj));
    }
    @Transactional
    public Page<UserDTO> findAllPaged(Pageable pageable) {
        Page<User> list = repository.findAll(pageable);
        return list.map(UserDTO::new);
    }
    @Transactional
    public UserDTO update(Long id, UserDTO dto) {
        try {
            User user = repository.getReferenceById(id);
            copyDtoToEntity(dto, user);
            return new UserDTO(repository.save(user));

        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found" + id);
        }
    }
    @Transactional
    public void delete(Long id) {

        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
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

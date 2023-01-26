package com.marcos.mrcjewelscatalog.dto;

import com.marcos.mrcjewelscatalog.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Long id;
    @NotBlank(message = "campo obrigatório")
    private String name;
    @Email(message = "Favor entrar um email válido")
    private String email;
    @NotBlank(message = "campo obrigatório")
    private String password;
    private Set<RoleDTO> rolesDTO = new HashSet<>();

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        user.getRoles().forEach(role -> rolesDTO.add(new RoleDTO(role))); ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

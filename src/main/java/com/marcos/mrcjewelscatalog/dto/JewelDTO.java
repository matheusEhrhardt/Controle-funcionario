package com.marcos.mrcjewelscatalog.dto;

import com.marcos.mrcjewelscatalog.entities.Category;
import com.marcos.mrcjewelscatalog.entities.Jewel;
import com.marcos.mrcjewelscatalog.entities.Role;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class JewelDTO {

    private Long id;
    @NotBlank(message = "campo obrigatório")
    private String name;
    @NotBlank(message = "campo obrigatório")
    private String description;
    private Double weight;
    private Double price;
    @NotBlank(message = "campo obrigatório")
    private CategoryDTO categoryDTO;

    public JewelDTO(Jewel entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.weight = entity.getWeight();
        this.price = entity.getPrice();
        this.categoryDTO = new CategoryDTO(entity.getCategory());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JewelDTO roleDTO = (JewelDTO) o;
        return Objects.equals(id, roleDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

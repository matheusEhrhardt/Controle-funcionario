package com.marcos.mrcjewelscatalog.dto;

import com.marcos.mrcjewelscatalog.entities.Category;
import com.marcos.mrcjewelscatalog.entities.Jewel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {

    private Long id;
    @NotBlank(message = "campo obrigatório")
    private String name;

    public CategoryDTO(Category entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDTO roleDTO = (CategoryDTO) o;
        return Objects.equals(id, roleDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

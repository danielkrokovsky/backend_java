package com.santana.java.back.end.dto;

import com.santana.java.back.end.model.Category;
import com.santana.java.back.end.model.Product;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CategoryDTO {

    @NotNull
    private Long id;
    private String nome;
    // gets e sets
    public static CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }
}

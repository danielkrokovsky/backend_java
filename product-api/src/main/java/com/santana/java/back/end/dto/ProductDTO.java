package com.santana.java.back.end.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProductDTO {
 
    @NotBlank
	private String productIdentifier;
    @NotBlank
	private String nome;
    @NotNull
    private Float preco;
    @NotNull
	private CategoryDTO category;

}

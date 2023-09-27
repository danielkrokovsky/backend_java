package com.santana.java.back.end.model;

import lombok.Data;

import javax.persistence.*;

import com.santana.java.back.end.dto.ProductDTO;

@Data
@Entity(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Float preco;
    private String descricao;
    private String productIdentifier;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public static Product convert(ProductDTO productDTO) {
        Product product = new Product();
        product.setNome(productDTO.getNome());
        product.setPreco(productDTO.getPreco());
        product.setDescricao(productDTO.getDescricao());
        product.setProductIdentifier(
                productDTO.getProductIdentifier());
        if (productDTO.getCategoryDTO() != null) {
            product.setCategory(
                    Category.convert(productDTO.getCategoryDTO()));
        }
        return product;
    }
}

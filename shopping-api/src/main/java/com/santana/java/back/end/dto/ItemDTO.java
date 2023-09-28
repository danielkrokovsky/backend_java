package com.santana.java.back.end.dto;

import com.santana.java.back.end.model.Item;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ItemDTO {

    @NotBlank
    private String productIdentifier;
    @NotNull
    private Float price;
    // get and sets
    public static ItemDTO convert(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProductIdentifier(
                item.getProductIdentifier());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    } }
package com.santana.java.back.end.model;

import javax.persistence.Embeddable;

import com.santana.java.back.end.dto.ItemDTO;

import lombok.Data;

@Data
@Embeddable
public class Item {

    private String productIdentifier;
    private Float price;
    // gets and sets
    public static Item convert(ItemDTO itemDTO) {
        Item item = new Item();
        item.setProductIdentifier(
                itemDTO.getProductIdentifier());
        item.setPrice(itemDTO.getPrice());
        return item;
    }
}

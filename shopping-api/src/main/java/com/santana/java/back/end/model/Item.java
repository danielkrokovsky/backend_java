package com.santana.java.back.end.model;

import com.santana.java.back.end.dto.ItemDTO;
import lombok.Data;

import javax.persistence.*;

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

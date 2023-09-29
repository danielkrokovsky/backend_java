package com.santana.java.back.end.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.santana.java.back.end.dto.ShopDTO;

import lombok.Data;

@Data
@Entity(name="shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userIdentifier;
    private float total;

    @Column(name = "date")
    private LocalDateTime date;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item",
            joinColumns = @JoinColumn(name = "shop_id"))
    private List<Item> items;

    public static Shop convert(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setTotal(shopDTO.getTotal());
        shop.setDate(shopDTO.getDate());
        shop.setItems(shopDTO
                .getItems()
                .stream()
                .map(Item::convert)
                .collect(Collectors.toList()));
        return shop;
    }
}
package com.santana.java.back.end.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santana.java.back.end.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>, ReportRepository{

    List<Shop> findAllByUserIdentifier(String userIdentifier);

    List<Shop> findAllByTotalGreaterThan(Float total);

    List<Shop> findAllByDateGreaterThan(LocalDateTime date);

}

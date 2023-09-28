package com.santana.java.back.end.repository;

import com.santana.java.back.end.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>, ReportRepository{

    public List<Shop> findAllByUserIdentifier(
            String userIdentifier);
    public List<Shop> findAllByTotalGreaterThan(Float total);
    List<Shop> findAllByDataGreaterThanEquals(Date data);

}

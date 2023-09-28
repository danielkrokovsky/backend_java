package com.santana.java.back.end.service;

import com.santana.java.back.end.converter.DTOConverter;
import com.santana.java.back.end.dto.ShopDTO;
import com.santana.java.back.end.dto.ShopReportDTO;
import com.santana.java.back.end.model.Shop;
import com.santana.java.back.end.repository.ReportRepository;
import com.santana.java.back.end.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ReportService {


    @Autowired
    private ReportRepository reportRepository;

    public List<ShopDTO> getShopsByFilter(
            Date dataInicio,
            Date dataFim,
            Float valorMinimo) {
        List<Shop> shops =
                reportRepository
                        .getShopByFilters(dataInicio, dataFim, valorMinimo);
        return shops
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());

    }
    public ShopReportDTO getReportByDate(
            Date dataInicio,
            Date dataFim) {
        return reportRepository
                .getReportByDate(dataInicio, dataFim);
    }
}

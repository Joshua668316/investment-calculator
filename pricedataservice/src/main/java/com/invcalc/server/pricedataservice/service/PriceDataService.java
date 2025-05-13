package com.invcalc.server.pricedataservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invcalc.server.pricedataservice.model.Price;
import com.invcalc.server.pricedataservice.repository.PriceRepository;

@Service
public class PriceDataService {
    @Autowired
    private PriceRepository priceRepository;
    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }
}

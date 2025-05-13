package com.invcalc.server.pricedataservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invcalc.server.pricedataservice.model.Price;
import com.invcalc.server.pricedataservice.service.PriceDataService;

@RestController
@RequestMapping("/pricedata")
public class PricedataController {
    @Autowired
    public PriceDataService priceDataService;

    @GetMapping
    public List<Price> getAllPrices() {
        return priceDataService.getAllPrices();
    }
}

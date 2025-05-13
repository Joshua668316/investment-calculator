package com.invcalc.server.pricedataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invcalc.server.pricedataservice.model.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {
    
}

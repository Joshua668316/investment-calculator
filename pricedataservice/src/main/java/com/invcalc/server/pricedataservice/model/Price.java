package com.invcalc.server.pricedataservice.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Price {
    @Id
    private Timestamp time;
    private Double value;


    public void setTimeStamp(Timestamp time) {
        this.time = time;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Timestamp getTimeStamp() {
        return time;
    }

    public Double getValue() {
        return value;
    }
}

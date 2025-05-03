package com.stock.proxy;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ReturnEntry {
   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
   private LocalDate buyDate;
   private int value; 
}

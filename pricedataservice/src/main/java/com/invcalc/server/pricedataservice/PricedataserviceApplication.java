package com.invcalc.server.pricedataservice;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.type.descriptor.jdbc.TimestampWithTimeZoneJdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import com.invcalc.server.pricedataservice.model.Price;
import com.invcalc.server.pricedataservice.repository.PriceRepository;


@SpringBootApplication
public class PricedataserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PricedataserviceApplication.class, args);
	}

	@Autowired
	private PriceRepository priceRepository;

	@Bean
	@ConditionalOnProperty(name = "db.init.enabled", havingValue = "true")
	public CommandLineRunner demoCommandLineRunner() {
		return args -> {
			System.out.println("cmd running---------------------------------------------------");
			List<Price> prices = new ArrayList<>();
			for (int i = 0; i < 100; i++) {
				Price p = new Price();
				p.setTimeStamp(new Timestamp(i));
				p.setValue((new Random()).nextDouble());
				prices.add(p);
			}
			priceRepository.saveAll(prices);
		};
	}
}

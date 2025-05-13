package com.invcalc.server.pricedataservice;

import java.sql.Timestamp;
import java.util.List;

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
			Price p1 = new Price();
			p1.setValue(1.0);
			p1.setTimeStamp(new Timestamp(0));
			priceRepository.saveAll(List.of(p1));
		};
	}
}

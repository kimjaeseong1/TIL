package com.example.coin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value= {"com.example.coin.mapper"})
public class CoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinApplication.class, args);
	}

}

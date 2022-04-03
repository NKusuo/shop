package com.company.shop;

import com.company.shop.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ShopApplication {

	@Autowired
	private ProductsService productsService;

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	private void test(){
		productsService.allProducts().forEach(it->System.out.println(it));
	}
}

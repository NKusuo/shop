package com.company.shop.Service;

import com.company.shop.Repository.ProductsRepository;
import com.company.shop.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {


    @Autowired
    private final ProductsRepository productsRepository;


    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public void  createProduct(Products product){
        productsRepository.save(product);
    }

    public List<Products> allProducts(){
        return productsRepository.allProducts();
    }
}

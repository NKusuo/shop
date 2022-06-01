package com.company.shop.Service;

import com.company.shop.Repository.ProductsRepository;
import com.company.shop.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductsService {


    @Autowired
    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    //добавление продукта в таблицу продукты
    public boolean createProduct(Products product){
        Products productsFromBD = productsRepository.findAllByTitle(product.getTitle());

        //если такой продукт есть, возвращаем ложь
        if(productsFromBD!=null && productsFromBD.getDescription().equals(product.getDescription())){
            return false;
        }
        productsRepository.save(product);
        return true;
    }

    public List<Products> allProducts(){
        return productsRepository.allProducts();
    }

    //удаление продукта по id
    @Transactional
    public void deleteProduct(Integer id) {
        long dp = productsRepository.deleteByIdProduct(id);
    }

    //Ищем по названию
    /*public List<Products> findTitleProduct(String title){
        return productsRepository.findAllByTitle(title);
    }*/

    //Ищем по id
    public Products findAllById(Integer id){
        return productsRepository.findAllByIdProduct(id);
    }

    //обновление количества товара
    @Transactional
    public void updateAmount(Integer idProduct, Integer newAmount){
        productsRepository.updateAmount(idProduct,newAmount);
    }

    public List<Products> statProducts(){
        return productsRepository.statProducts();
    }
}

package com.company.shop.Repository;

import com.company.shop.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products,Long> {

    //список товаров
    @Query("select new Products(p.title, p.description, p.amount, p.price) from Products p" )
    List<Products> allProducts();

    //удаление продукта по id
    Long deleteByIdProduct(Integer id);

    //Ищем товар по названию
    List<Products> findAllByTitle(String title);

}

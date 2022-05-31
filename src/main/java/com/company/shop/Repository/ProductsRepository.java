package com.company.shop.Repository;

import com.company.shop.domain.Products;
import com.company.shop.statisticsPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products,Long> {

    //список товаров
    @Query(value = "SELECT * FROM Products ",
            nativeQuery = true )
    List<Products> allProducts();

    //удаление продукта по id
    Long deleteByIdProduct(Integer id);


    //Ищем товар по названию
    Products findAllByTitle(String title);

    //Ищем товар по id
    Products findAllByIdProduct(Integer id);

    //Обновление количества товаров
    @Modifying
    @Query("UPDATE Products SET amount =:newAmount WHERE idProduct=(:idProduct)")
    Integer updateAmount(Integer idProduct, Integer newAmount);

   /* //статистика
    @Query(value = "select o.idproduct,  amount(o.idproduct) profit from orderand_product o order by profit desc ",
            nativeQuery = true )
    List<statisticsPrice> statProducts();*/
}

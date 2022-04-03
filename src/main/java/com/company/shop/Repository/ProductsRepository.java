package com.company.shop.Repository;

import com.company.shop.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products,Long> {

    @Query("select p.title, p.description, p.amount, p.price from Products p" )
    List<Products> allProducts();

}

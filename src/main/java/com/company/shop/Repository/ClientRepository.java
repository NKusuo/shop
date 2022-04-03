package com.company.shop.Repository;

import com.company.shop.domain.Client;
import com.company.shop.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

    //Ищем товар по названию
    Client findAllByIdClient(Integer id);
}

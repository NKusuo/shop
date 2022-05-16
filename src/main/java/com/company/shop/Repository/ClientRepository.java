package com.company.shop.Repository;

import com.company.shop.domain.Client;
import com.company.shop.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

    //Ищем клиента по id
    Client findAllByIdClient(Integer id);

    Client findByLogin(String Login);

    /*@Query(value = "SELECT e from Client as e WHERE e.login=:log and e.pass=:pass", nativeQuery = true)
    Client findByPassEndLogin(String pass,String log);*/
}

package com.company.shop.Repository;

import com.company.shop.domain.Orders;
import com.company.shop.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Long> {

    @Query(value ="SELECT idOrder,status FROM Orders ",
            nativeQuery = true)
    List<Orders> ordersStatus();

    //список заказов
    @Query(value = "SELECT * FROM Orders ",
            nativeQuery = true )
    List<Orders> allOrders();

    List<Orders> findAllByIdclient(Integer idClient);

    Orders findAllByIdOrder(Integer id);

    //Обновление статуса
    @Modifying
    @Query("UPDATE Orders SET status = :newStatus WHERE idOrder=(:idOrder)")
    int updateStatus(Integer idOrder, String newStatus);






}

package com.company.shop.Service;

import com.company.shop.Repository.OrdersRepository;
import com.company.shop.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {
    //конструктор, автоматичсеки заполняет поле инъекцией зависимости Spring
    @Autowired
    private final OrdersRepository ordersRepository;

    public OrderService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }


    public void createOrder(Orders order){
        ordersRepository.save(order);
    }
     //все заказы по id клиента
    public List<Orders> findAllByIdClient(Integer idClient){
        return ordersRepository.findAllByIdclient(idClient);
    }
    // выводим информацию по заказу по его id
    public Orders findAllByIdorder(Integer id){
        return ordersRepository.findAllByIdOrder(id);
    }
    //вывод id заказа и статус заказа
    public List<Orders> ordersStatus(){
        return ordersRepository.ordersStatus();
    }

    //обновление статуса
    @Transactional
    public void updateStatus(Integer idOrder, String status){
        ordersRepository.updateStatus(idOrder,status);
    }
}

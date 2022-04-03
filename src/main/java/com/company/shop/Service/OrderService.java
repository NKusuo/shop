package com.company.shop.Service;

import com.company.shop.Repository.OrdersRepository;
import com.company.shop.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private final OrdersRepository ordersRepository;

    public OrderService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }


    public void createOrder(Orders order){
        ordersRepository.save(order);
    }

    public List<Orders> findAllByIdClient(Integer idClient){
        return ordersRepository.findAllByIdclient(idClient);
    }

    public Orders findAllByIdorder(Integer id){
        return ordersRepository.findAllByIdOrder(id);
    }

    public List<Orders> ordersStatus(){
        return ordersRepository.ordersStatus();
    }

    //обновление статуса
    @Transactional
    public void updateStatus(Integer idOrder, String status){
        ordersRepository.updateStatus(idOrder,status);
    }
}

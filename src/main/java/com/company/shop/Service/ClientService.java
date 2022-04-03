package com.company.shop.Service;

import com.company.shop.Repository.AdminRepository;
import com.company.shop.Repository.ClientRepository;
import com.company.shop.domain.Admin;
import com.company.shop.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void  createClient(Client client){
        clientRepository.save(client);
    }

    //Ищем клиента по  id (пока не нужно)
    public Client findById(Integer id){
        return clientRepository.findAllByIdClient(id);
    }
}

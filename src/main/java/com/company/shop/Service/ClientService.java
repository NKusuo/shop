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

    public boolean  createClient(Client client){
        Client clientFromBD = clientRepository.findByLogin(client.getLogin());

        //если логин занят, возвращаем ложь
        if(clientFromBD!=null){
            return false;
        }
        clientRepository.save(client);
        return true;
    }

    //Ищем клиента по  id (пока не нужно)
    public Client findById(Integer id){
        return clientRepository.findAllByIdClient(id);
    }

    public boolean findByPassAndLogin(String log, String psw){
       Client clientFromBD = clientRepository.findByLogin(log);

        if(clientFromBD!=null && clientFromBD.getPass()==psw){
            return true;
        }
        return false;
    }
}

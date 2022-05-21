package com.company.shop.Service;

import com.company.shop.Repository.AdminRepository;
import com.company.shop.Repository.ProductsRepository;
import com.company.shop.domain.Admin;
import com.company.shop.domain.Client;
import com.company.shop.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void  createAdmin(Admin admin){
        adminRepository.save(admin);
    }

    public boolean findByPassAndLogin(String log, String psw){

        Admin clientFromBD = adminRepository.findByLogin(log);

        if(clientFromBD!=null && psw.equals(clientFromBD.getPass())){
            return true;
        }
        return false;
    }
}

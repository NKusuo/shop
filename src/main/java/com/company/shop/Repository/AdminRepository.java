package com.company.shop.Repository;

import com.company.shop.domain.Admin;
import com.company.shop.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByLogin(String Login);
}

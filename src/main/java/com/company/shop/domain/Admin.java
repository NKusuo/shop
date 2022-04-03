package com.company.shop.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="admin")
public class Admin {


    @Id
    @Column(name="idadmin")
    //стратегия -  id будет создаваться так, как мы указали в бд
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdmin;

    @Column(name = "fio")
    private String fio;

    @Column(name = "login")
    private String login;

    @Column(name = "pass")
    private String pass;

    @Column(name = "phone")
    private Long phone;

    public Admin() {
    }

    public Admin(Integer idAdmin, String fio, String login, String pass, Long phone) {
        this.idAdmin = idAdmin;
        this.fio = fio;
        this.login = login;
        this.pass = pass;
        this.phone = phone;
    }

    //связь админа с заказами
    @OneToMany(mappedBy = "primaryAdmin", fetch = FetchType.EAGER)
    private List<Orders> ordersAdmin;
}
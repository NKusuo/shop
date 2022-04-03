package com.company.shop.domain;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="client")
public class Client {



    @Id
    @Column(name="idclient")
    //стратегия -  id будет создаваться так, как мы указали в бд
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;



    @Column(name="fio")
    private String fio;

    @Column(name="bday")
    private Calendar bday;

    @Column(name="login")
    private String login;

    @Column(name="pass")
    private String pass;

    @Column(name="address")
    private Calendar address;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private Long phone;

    public Client() {
    }

    public Client(Integer idClient, String fio, Calendar bday, String login, String pass, Calendar address, String email, Long phone) {
        this.idClient = idClient;
        this.fio = fio;
        this.bday = bday;
        this.login = login;
        this.pass = pass;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    //связь клиента с заказами
    @OneToMany(mappedBy = "primaryClient", fetch = FetchType.EAGER)
    private List<Orders> ordersClient;

}

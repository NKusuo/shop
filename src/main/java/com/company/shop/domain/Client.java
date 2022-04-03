package com.company.shop.domain;

import javax.persistence.*;
import javax.xml.crypto.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="client")
public class Client {



    @Id
    @Column(name="idclient")
    //стратегия -  id будет создаваться последовательностью
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;

    @Column(name="fio")
    private String fio;

    @Column(name="bday")
    private Date bday;

    @Column(name="login")
    private String login;

    @Column(name="pass")
    private String pass;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private Long phone;

    public Client() {
    }

    public Client( String fio, Date bday, String login, String pass, String address, String email, Long phone) {
        this.fio = fio;
        this.bday = bday;
        this.login = login;
        this.pass = pass;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    //связь клиента с заказами
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Orders> ordersClient;

    public Integer getIdClient() {
        return idClient;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    //@Temporal(TemporalType.DATE)
    public Date getBday() {
        return bday;
    }

    public void setBday(Date bday) {
        this.bday = bday;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}

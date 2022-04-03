package com.company.shop.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="admin")
public class Admin {


    @Id
    @Column(name="idadmin")
    //
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

    public Admin(String fio, String login, String pass, Long phone) {
        this.fio = fio;
        this.login = login;
        this.pass = pass;
        this.phone = phone;
    }

    //связь админа с заказами
    @OneToMany(mappedBy = "admin", fetch = FetchType.EAGER)
    private List<Orders> orderAdmin;

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
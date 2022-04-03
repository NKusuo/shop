package com.company.shop.domain;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name="orders")
public class Orders {

    @Id
    @Column(name="idorder")

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;


    @Column(name = "idclient")
    private Integer idclient;

    @Column(name = "idproduct")
    private Integer idproduct;

    @Column(name = "status")
    private String status;

    @Column(name="date")
    private Calendar date;

    @Column(name = "price")
    private Integer price;

    public Orders() {
    }

    public Orders(Integer idclient, Integer idproduct, String status, Calendar date, Integer price){
        this.idclient = idclient;
        this.idproduct = idproduct;
        this.status = status;
        this.date = date;
        this.price = price;
    }
    //связь заказов с клиентом
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "idclient", insertable =  false, updatable = false)
    private Client client;

    //не работает пока
   /* //связь заказов с товарами
    @ManyToMany
    @JoinTable(name = "LIST_PRODUCTS_IN_ORDER",
            joinColumns = @JoinColumn(name = "orders_idclient_fkey"),
            inverseJoinColumns = @JoinColumn(name = "idproduct"))
    protected List<Products> productsInOrder;
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<Products> orderProducts;*/

    //связь заказов с админом
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "idadmin")
    private Admin admin;

    public Integer getIdOrder() {
        return idOrder;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public Integer getIdproduct() {
        return idproduct;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

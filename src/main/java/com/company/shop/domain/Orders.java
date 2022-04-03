package com.company.shop.domain;

import javax.persistence.*;
import java.util.Date;
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

    @Temporal(TemporalType.DATE)
    @Column(name="dateorder")
    private Date dateOrder;

    @Column(name = "price")
    private Integer price;

    public Orders() {
    }

    public Orders(Integer idclient, Integer idproduct, String status, Date date, Integer price){
        this.idclient = idclient;
        this.idproduct = idproduct;
        this.status = status;
        this.dateOrder = date;
        this.price = price;
    }

    public Orders(Integer idOrder,Integer idclient, Integer idproduct, String status, Date date, Integer price){
        this.idOrder=idOrder;
        this.idclient = idclient;
        this.idproduct = idproduct;
        this.status = status;
        this.dateOrder = date;
        this.price = price;
    }

    public Orders(Integer idOrder, String status){
        this.idOrder=idOrder;
        this.status = status;
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

    //связь заказов с админом ВОЗМОЖНО НЕ НУЖНА
   /* @ManyToOne //(optional = false)
    @JoinColumn(name = "idadmin")
    private Admin admin;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Integer getIdOrder() {
        return idOrder;
    }*/

    //Вывод заказаов
    public String printOrder() {
        return(this.status+" "+this.dateOrder+" "+this.price).toString();
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

    public Date getDate() {
        return dateOrder;
    }

    public void setDate(Date date) {
        this.dateOrder = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    //вывод номера заказа и статус
    public String printOrderStatus() {
        return (this.idOrder+" "+this.status).toString();
    }
}

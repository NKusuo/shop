package com.company.shop.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
public class Orders {

    @Id
    @Column(name="idorder")

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idOrder;


    @Column(name = "idclient")
    private Integer idclient;

    //@Column(name = "idproduct")
    //private Integer idproduct;

    @Column(name = "status")
    private String status;

    @Temporal(TemporalType.DATE)
    @Column(name="dateorder")
    private Date dateOrder;

    @Column(name = "price")
    private Integer price;

    public Orders() {
    }

    public Orders(Integer idclient,  String status, Date date, Integer price,List<Products> listProducts){
        this.idclient = idclient;
        this.status = status;
        this.dateOrder = date;
        this.price = price;
        this.listProducts = listProducts;
    }


    public Orders(Integer idOrder, String status){
        this.idOrder=idOrder;
        this.status = status;
    }

    //связь заказов с клиентом
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "idclient", insertable =  false, updatable = false)
    private Client client;

    //связь заказа с товарами
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "OrderandProduct",
            joinColumns = @JoinColumn(name = "idorder"),
            inverseJoinColumns = @JoinColumn(name = "idproduct"))
    List<Products> listProducts;

    public List<Products> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<Products> listProducts) {
        this.listProducts = listProducts;
    }

    //Вывод заказаов
    public String printOrder() {
        return(this.status+" "+this.dateOrder+" "+this.price).toString();
    }

    public Integer getIdclient() {
        return idclient;
    }

    /*public Integer getIdproduct() {
        return idproduct;
    }*/

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

    public String printAllOrders(){
        //("Дата заказа" +this.dateOrder);
        String hhh="";
        for(int i=0;i<this.listProducts.size();++i){
            hhh+=this.listProducts.get(i).getTitle()+"\n";
        }
        //System.out.println("Цена " +this.price);
        //System.out.println("Статус " +this.status);
        return ("Дата заказа " +this.dateOrder +"\n"+ hhh+ "Цена " +this.price+"\n"+"Статус " +this.status+"\n");
    }
}

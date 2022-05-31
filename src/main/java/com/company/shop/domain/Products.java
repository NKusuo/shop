package com.company.shop.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="products")
public class Products {

    @Id
    @Column(name="idproduct")

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idProduct;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Integer price;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "listProducts")
    List<Orders> listOrders;

    public Products() {
    }

    public Products( String title, String description, Integer amount, Integer price) {
        this.title = title;
        this.price = price;
        this.amount = amount;
        this.description = description;
    }

    /*
    //вывод объекта в консоль
    public String printProduct(){
        return (this.title + " "+ this.amount+" "+ this.description+" "+this.price).toString();
    }*/

    public Integer getIdProduct() {
        return this.idProduct;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
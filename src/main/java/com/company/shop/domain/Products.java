package com.company.shop.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="products")
public class Products {


    @Id
    @Column(name="idproduct")
    //стратегия -  id будет создаваться так, как мы указали в бд
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Integer price;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "description")
    private String description;

    public Products() {
    }

    public Products( Integer idProduct,String title, Integer price, Integer amount,String description) {
        this.idProduct=idProduct;
        this.title = title;
        this.price = price;
        this.amount = amount;
        this.description = description;
    }



    //связь товаров с заказами
    @ManyToMany(mappedBy = "productsInOrder")
    protected List<Orders> ordersProduct;


}
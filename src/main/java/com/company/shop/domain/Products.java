package com.company.shop.domain;

import javax.persistence.*;

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

    public Products( String title, String description, Integer amount, Integer price) {
        this.title = title;
        this.price = price;
        this.amount = amount;
        this.description = description;
    }

    /*
    private int profitSum;

    public Products(Integer idProduct, int profitSum) {
        this.idProduct = idProduct;
        this.profitSum = profitSum;
    }
    //Вывод прибыли
    public String printProfit(){
        return (this.idProduct+" "+this.profitSum).toString();
    }*/

    //вывод объекта в консоль
    public String printProduct(){
        return (this.title + " "+ this.amount+" "+ this.description+" "+this.price).toString();
    }



    //не работате пока, не знаю че делать
/*
    //связь товаров с заказами
    @ManyToMany(mappedBy = "productsInOrder")
    protected List<Orders> ordersProduct;


    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "idorder")
    private Orders order;
*/
    public Integer getIdProduct() {
        return idProduct;
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
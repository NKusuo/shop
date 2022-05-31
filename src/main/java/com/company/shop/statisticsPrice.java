package com.company.shop;

public class statisticsPrice {

    private Integer id;
    private Integer profit;


    public statisticsPrice(Integer id, Integer profit) {
        this.id = id;
        this.profit = profit;
    }

    public Integer getProfit() {
        return profit;
    }

    public Integer getId() {
        return id;
    }


}

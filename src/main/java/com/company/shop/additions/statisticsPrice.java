package com.company.shop.additions;

public class statisticsPrice implements Comparable<statisticsPrice>{

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

    @Override
    public int compareTo(statisticsPrice o) {
        if (getProfit() == null || o.getProfit() == null) {
            return 0;
        }
        return getProfit().compareTo(o.getProfit());
    }
}

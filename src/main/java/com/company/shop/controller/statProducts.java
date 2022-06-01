package com.company.shop.controller;

import com.company.shop.Service.ProductsService;
import com.company.shop.additions.statisticsPrice;
import com.company.shop.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class statProducts {

    @Autowired
    ProductsService productsService;

    @GetMapping("/statProducts.html")
    public String stat( Model model) {

        List<Products> statistics = productsService.statProducts();
        int[] mass= new int[statistics.size()];
        for(int i=0;i<statistics.size();++i){
            mass[i]=statistics.get(i).getIdProduct();
        }

        //удаляем повторяющиеся продукты
        for (int i = 0; i <  statistics.size() - 1; i++) {
            // Начинаем переход вперед из списка с индексом list.size () - 1
            for (int j =  statistics.size() - 1; j > i; j--) {
                // Сравнить
                if ( statistics.get(j).equals( statistics.get(i))) {
                    // дедупликация
                    statistics.remove(j);
                }
            }
        }

        //считаем число повторений
        ArrayList<statisticsPrice> result = new ArrayList<>();
        List<Products> temp = productsService.statProducts();
        int count=0;
        for(int i=0;i<statistics.size();++i){
            for(int j=0;j<temp.size();++j){
                if(statistics.get(i).getIdProduct() == temp.get(j).getIdProduct()){
                    ++count;
                }
            }
            result.add(new statisticsPrice(statistics.get(i).getIdProduct(),count));
            count=0;
        }
        Collections.sort(result);
        Collections.reverse(result);
        model.addAttribute("statistics",result);
        return "statProducts.html";
    }

}

package com.company.shop.domain;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class addProd {
    private List<Integer> checkedItems;

    public List<Integer> getCheckedItems() {
        return checkedItems;
    }

    public void setCheckedItems(List<Integer> addCheckbox) {
        this.checkedItems = addCheckbox;
    }
}

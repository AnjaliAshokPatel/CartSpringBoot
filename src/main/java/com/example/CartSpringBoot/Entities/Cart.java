package com.example.CartSpringBoot.Entities;

import com.example.CartSpringBoot.ProductDao;
import com.example.CartSpringBoot.PromotionUtil;

import java.util.Map;

public class Cart {

    private Map<String,Integer> quantities;
    private ProductDao productDao;

    public Cart(Map<String, Integer> quantities,ProductDao productDao) throws Exception {
        this.quantities = quantities;
        this.productDao = productDao;
        validateCart();
    }

    private void validateCart() throws Exception {
        for(String name : quantities.keySet()){
            if(quantities.get(name) < 0){
                throw new IllegalArgumentException("Invalid quantity of product "+name);
            }
            productDao.getProductByName(name);
        }
    }

    public double calculateDiscount() throws Exception {
        return Math.max(PromotionUtil.getDiscount1(quantities,productDao),
                            PromotionUtil.getDiscount2(quantities,productDao));
    }

    public double calculateTotal() throws Exception {
        double total = 0;
        for(String name : quantities.keySet()){
            total += quantities.get(name) * productDao.getProductPrice(name);
        }
        return total;
    }

}

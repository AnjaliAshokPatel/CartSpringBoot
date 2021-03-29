package com.example.CartSpringBoot;

import com.example.CartSpringBoot.Entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    ProductDao productDao;

    public Map<String,Double> calculateTotal(Map<String,Integer> quantities) throws Exception {
        Cart cart = new Cart(quantities,productDao);
        double cartTotal = cart.calculateTotal();
        double discount = cart.calculateDiscount();
        double finalTotal = cartTotal - discount;

        Map<String,Double> result = new HashMap<>();
        result.put("Cart Total",cartTotal);
        result.put("Discount", discount);
        result.put("Final total",finalTotal);

        return result;
    }

}

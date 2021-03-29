package com.example.CartSpringBoot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PromotionUtil {

    public static double getDiscount1(Map<String,Integer> quantities, ProductDao productDao) throws Exception {
        if(!(quantities.containsKey("A")&& quantities.containsKey("B"))){
            return 0;
        }
        int numA = quantities.get("A");
        int numB = quantities.get("B");
        int num = Math.min(numA,numB);
        return (num*productDao.getProductPrice("B"))/2;
    }

    public static double getDiscount2(Map<String,Integer> quantities, ProductDao productDao) throws Exception {
        String[] products = new String[]{"A","B","C","D","E"};
        Map<String,Integer> counts = new HashMap<>();
        double cheapestProductPrice = -1;
        int cheapestProductQuantity = 0;
        for(String name : products){
            if(quantities.containsKey(name)){
                if(cheapestProductPrice == -1){
                    cheapestProductPrice = productDao.getProductPrice(name);
                    cheapestProductQuantity = quantities.get(name);
                }
                else{
                    cheapestProductPrice = Math.min(cheapestProductPrice,productDao.getProductPrice(name));
                    cheapestProductQuantity = quantities.get(name);
                }
                counts.put(name, quantities.get(name));
            }
        }
        if(counts.size() < 3) return 0;

        Integer[] values = counts.values().toArray(new Integer[0]);
        Arrays.sort(values);

        if(cheapestProductQuantity == values[0] || cheapestProductQuantity == values[1] || cheapestProductQuantity == values[2]){
            return cheapestProductPrice*values[2];
        }
        return cheapestProductPrice*cheapestProductQuantity;
    }

}

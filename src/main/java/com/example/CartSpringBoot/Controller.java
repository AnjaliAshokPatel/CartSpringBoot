package com.example.CartSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    Service service;

    @GetMapping("/calculateTotal")
    public Map<String,Double> calculateTotal(@RequestBody Map<String,Integer> quantities) {
        try {
            return service.calculateTotal(quantities);
        } catch (Exception e) {
            Map<String,Double> res = new HashMap<>();
            res.put("Error! "+e.getMessage(),-1.);
            return res;
        }
    }

}

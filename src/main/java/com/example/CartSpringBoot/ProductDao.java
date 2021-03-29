package com.example.CartSpringBoot;

import com.example.CartSpringBoot.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao {

    private static final String filePath = "C:\\Users\\srika\\Desktop\\spring\\CartSpringBoot\\src\\products.txt";

    private List<Product> products;


    public ProductDao(String filePath) throws Exception {
        products = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while((line = reader.readLine())!=null){
            String[] data = line.split(" ");
            if(data.length!=2){
                throw new Exception("Incorrect format of input data");
            }

            Product product = new Product(data[0],Double.parseDouble(data[1]));
            products.add(product);

        }

    }

    @Autowired
    public ProductDao() throws Exception {
        this(filePath);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductByName(String name) throws Exception {
        for(Product product : products){
            if(name.equals(product.getName())){
                return product;
            }
        }
        throw new Exception("Product with name : "+name+" does not exist!");
    }

    public double getProductPrice(String name) throws Exception {
        return getProductByName(name).getPrice();
    }

}

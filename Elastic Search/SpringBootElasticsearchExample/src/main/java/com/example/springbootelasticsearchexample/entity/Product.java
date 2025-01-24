package com.example.springbootelasticsearchexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "products")
public class Product {
   private int id;
    private String name;
    private String description;

    private int quantity;

    private double price;

    public void setName(String name)
    {
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setPrice(double price)
    {
        this.price=price;
    }
    public double getPrice(){
        return price;
    }

}

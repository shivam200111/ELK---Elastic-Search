package com.example.springbootelasticsearchexample.entity;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "products")
public class Product {
   private int id;
    @Setter
    @Getter
    private String name;

    private String description;

    private int quantity;

    @Getter
    @Setter
    private double price;

}

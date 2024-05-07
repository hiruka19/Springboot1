package com.ijse.hellospring.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

//ID, name, price,qty

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity // 1
@Getter // 6
@Setter // 6
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 5
    private Long id; // 2

    private String name; // 3

    private Double Price; // 4
    
    private String Quantity; // 4


// return related category object
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category; 

    @JsonIgnore
    @ManyToMany(mappedBy = "orderedProducts")
    private List<Order> orders;
}

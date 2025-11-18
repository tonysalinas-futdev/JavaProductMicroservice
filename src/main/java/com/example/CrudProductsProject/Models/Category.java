package com.example.CrudProductsProject.Models;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.OneToMany;;

@Data
@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column
    private String name;

    @Column
    private String pic;

    @Column
    private String description;

    @OneToMany(mappedBy="category")
    private List<Product> productos=new ArrayList<Product>();

    public Category(){}



}

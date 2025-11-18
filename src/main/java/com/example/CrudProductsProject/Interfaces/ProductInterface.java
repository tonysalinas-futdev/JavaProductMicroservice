package com.example.CrudProductsProject.Interfaces;


import com.example.CrudProductsProject.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductInterface extends JpaRepository<Product,Long>{
    @Query(value = "SELECT p FROM Product p WHERE p.name = :name")
    Product getByName(@Param("name") String name);
    @Query(value = "SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product>filterByPrice(@Param("minPrice")Double minPrice, @Param("maxPrice") Double maxPrice);

    @Query(value="SELECT p FROM Product p WHERE p.price< :maxPrice")
    List<Product>filterByMaxPrice(@Param("maxPrice") Double maxPrice);

    @Query(value="SELECT p FROM Product p WHERE p.price> :minPrice")
    List<Product>filterByMinPrice(@Param("minPrice") Double minPrice);

    @Query(value="SELECT p FROM Product p INNER JOIN p.category c WHERE c.id= :categoryId")
    List<Product>filterByCategory(@Param("categoryId") Integer categoryId);


}

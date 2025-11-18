package com.example.CrudProductsProject.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.CrudProductsProject.Models.Category;
public interface CategoryInterface extends JpaRepository<Category,Long>{
    @Query(value = "SELECT c FROM Category c WHERE c.name= :name")
    Category getByName(@Param("name") String name);

}

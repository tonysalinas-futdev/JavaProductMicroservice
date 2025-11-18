package com.example.CrudProductsProject.Dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record createProduct(
    @NotNull
    String name, 
    
    @Size(max = 2000)
    String description, 
    
    @NotNull
    Double price , 
    

    @Min(0)
    Integer stock, 
    
    String pic,

    @NotNull
    Long categoryId
    ) 
    {

}

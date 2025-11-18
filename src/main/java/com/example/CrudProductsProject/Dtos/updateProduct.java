package com.example.CrudProductsProject.Dtos;

import jakarta.validation.constraints.*;

public record updateProduct(

    
    String name,

    @Size(max = 2000, message = "La descripción no puede superar los 2000 caracteres")
    String description,

    Double price,

    @Positive
    Integer stock,

    String pic

) {}

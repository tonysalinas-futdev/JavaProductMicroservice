package com.example.CrudProductsProject.Dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record createCategory(

    @NotNull
    @Size(max = 700)
    String name,

    @Size(max = 2000)
    String description,

    String pic

    

) {

}

package com.example.CrudProductsProject.Dtos;

import jakarta.validation.constraints.Size;

public record updateCategory(
    @Size(max = 700)
    String name,

    @Size(max = 2000)
    String description,

    String pic
) {

}

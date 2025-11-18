package com.example.CrudProductsProject.Services;
import com.example.CrudProductsProject.Dtos.createCategory;
import com.example.CrudProductsProject.Interfaces.CategoryInterface;
import com.example.CrudProductsProject.Models.Category;
import com.example.CrudProductsProject.Dtos.updateCategory;

import org.springframework.beans.factory.annotation.Autowired;

public class CategoryService {
    @Autowired
    CategoryInterface categoryRepo;

    public Category toEntity(createCategory categoryDto){
        Category categoryEntity=new Category();
        categoryEntity.setName(categoryDto.name());
        categoryEntity.setDescription(categoryDto.description());
        categoryEntity.setPic(categoryDto.pic());
        return categoryEntity;
    }

    public Category createCategory(createCategory category)throws IllegalArgumentException{
        var existing_category=this.categoryRepo.getByName(category.name());
        if (existing_category!=null) {
            throw new IllegalArgumentException("Ya existe una categoría con ese nombre");}
        Category new_category=this.toEntity(category);
        this.categoryRepo.saveAndFlush(new_category);
        return new_category;
    }

    public Category updateCategory(updateCategory data, Long categoryId)throws IllegalArgumentException{
        var category=this.categoryRepo.findById(categoryId).orElseThrow(()->new IllegalArgumentException("No se ha podido encontrar la categoría"));
        var existing_category=this.categoryRepo.getByName(data.name());
        if (existing_category!=null) {
            throw new IllegalArgumentException("Ya existe una categoría con ese nombre");}
        
        if (data.name()!=null) {category.setName(data.name());}
        if (data.description()!=null) {category.setDescription(data.description());}
        if (data.pic()!=null) {category.setPic(data.pic());}
        
        this.categoryRepo.saveAndFlush(category);
        return category;


    }
}

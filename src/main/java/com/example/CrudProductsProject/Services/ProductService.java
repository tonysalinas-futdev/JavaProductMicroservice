package com.example.CrudProductsProject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.CrudProductsProject.Dtos.createProduct;
import com.example.CrudProductsProject.Dtos.updateProduct;
import com.example.CrudProductsProject.Interfaces.CategoryInterface;
import com.example.CrudProductsProject.Interfaces.ProductInterface;
import com.example.CrudProductsProject.Models.Product;

public class ProductService {

    @Autowired
    private ProductInterface productRepo;
    private CategoryInterface categoryRepo;

    
    private Product toEntity(createProduct product){
        Product model_product=new Product();
        model_product.setName(product.name());
        model_product.setDescription(product.description());
        model_product.setPrice(product.price());
        model_product.setPic(product.pic());
        model_product.setStock(product.stock());

        return model_product;
    }

    public createProduct toDto(Product product){
        createProduct product_dto= new createProduct(
            product.getName(),
            product.getDescription(), 
            product.getPrice(), 
            product.getStock(),
            product.getPic(),
            product.getCategory().getId()
        );
        return product_dto;
    }

    public Product createProduct(createProduct product) throws IllegalArgumentException{
        var existing_name= this.productRepo.getByName(product.name());
        if (existing_name != null) {
            throw new IllegalArgumentException("Ya existe un producto con ese nombre");}
        

        var existing_category=this.categoryRepo.findById(product.categoryId()).orElseThrow(()->new IllegalArgumentException("No se ha podido encontrar esa categoría"));


        Product new_product=this.toEntity(product);
        new_product.setCategory(existing_category);
        this.productRepo.saveAndFlush(new_product);
        return new_product;
        
        }

    public Product updateProduct(updateProduct newData, Long productId)throws IllegalArgumentException{
        Product product=this.productRepo.findById(productId).orElseThrow(()->new IllegalArgumentException());

        var existing_name= this.productRepo.getByName(newData.name());
        if (existing_name != null) {
            throw new IllegalArgumentException("Ya existe un producto con ese nombre");}

        if (newData.name()!=null) {product.setName(newData.name());}
        if (newData.price()!=null) {product.setPrice(newData.price());}
        if (newData.stock()!=null) {product.setStock(newData.stock());}
        if (newData.description()!=null) {product.setDescription(newData.description());}
        if (newData.pic()!=null) {product.setPic(newData.pic());}
        
        this.productRepo.saveAndFlush(product);
        return product;}
        




}

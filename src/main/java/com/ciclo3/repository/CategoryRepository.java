package com.ciclo3.repository;

import com.ciclo3.model.Category;
import com.ciclo3.repository.crud.CategoryRepositoryCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryRepositoryCrud categoryRepositoryCrud;
    
    public List<Category> getAll(){
        return (List<Category>) categoryRepositoryCrud.findAll();
    }
    
    public Optional<Category> getCategory(int Id){
        return categoryRepositoryCrud.findById(Id);
    }
    
    public Category save(Category c){
        return categoryRepositoryCrud.save(c);
    }
    
    public void delete(Category c){
        categoryRepositoryCrud.delete(c);
    }
}

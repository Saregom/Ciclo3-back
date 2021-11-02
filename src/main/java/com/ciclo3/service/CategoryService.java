package com.ciclo3.service;

import com.ciclo3.model.Category;
import com.ciclo3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    
    public Category save(Category c){
        if(c.getId()==null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> aux=categoryRepository.getCategory(c.getId());
            if(!aux.isPresent()){
                return categoryRepository.save(c);
            }else{
                return c;
            }
        }
    }
    
    public Category update(Category c){
        if(c.getId()!=null){
            Optional<Category> e=categoryRepository.getCategory(c.getId());
            if(e.isPresent()){
                if(c.getName()!=null){
                    e.get().setName(c.getName());
                }
                if(c.getDescription()!=null){
                    e.get().setDescription(c.getDescription());
                }
                categoryRepository.save(e.get());
                return categoryRepository.save(e.get());
            }else{
                return c;
            }
        }else{
            return c;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}


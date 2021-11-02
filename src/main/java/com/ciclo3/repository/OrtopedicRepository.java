package com.ciclo3.repository;

import com.ciclo3.model.Ortopedic;
import com.ciclo3.repository.crud.OrtopedicRepositoryCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrtopedicRepository {
    @Autowired
    private OrtopedicRepositoryCrud ortopedicRepositoryCrud;
    
    public List<Ortopedic> getAll(){
        return (List<Ortopedic>) ortopedicRepositoryCrud.findAll();
    }
    
    public Optional<Ortopedic> getOrtopedic(int Id){
        return ortopedicRepositoryCrud.findById(Id);
    }
    
    public Ortopedic save(Ortopedic o){
        return ortopedicRepositoryCrud.save(o);
    }
    
    public void delete(Ortopedic o){
        ortopedicRepositoryCrud.delete(o);
    }
}

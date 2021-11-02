package com.ciclo3.repository;

import com.ciclo3.model.Admin;
import com.ciclo3.repository.crud.AdminRepositoryCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
    @Autowired
    private AdminRepositoryCrud adminRepositoryCrud;
    
    public List<Admin> getAll(){
        return (List<Admin>) adminRepositoryCrud.findAll();
    }
    
    public Optional<Admin> getAdmin(int Id){
        return adminRepositoryCrud.findById(Id);
    }
    
    public Admin save(Admin a){
        return adminRepositoryCrud.save(a);
    }
    
    public void delete(Admin a){
        adminRepositoryCrud.delete(a);
    }
}

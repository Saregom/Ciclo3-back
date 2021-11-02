package com.ciclo3.service;

import com.ciclo3.model.Admin;
import com.ciclo3.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    
    public Admin save(Admin a){
        if(a.getIdAdmin()==null){
            return adminRepository.save(a);
        }else{
            Optional<Admin> aux=adminRepository.getAdmin(a.getIdAdmin());
            if(!aux.isPresent()){
                return adminRepository.save(a);
            }else{
                return a;
            }
        }
    }
    
    public Admin update(Admin a){
        if(a.getIdAdmin()!=null){
            Optional<Admin> e=adminRepository.getAdmin(a.getIdAdmin());
            if(e.isPresent()){
                if(a.getName()!=null){
                    e.get().setName(a.getName());
                }
                if(a.getPassword()!=null){
                    e.get().setPassword(a.getPassword());
                }
//                adminRepository.save(e.get());
                return adminRepository.save(e.get());
            }else{
                return a;
            }
        }else{
            return a;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getAdmin(id).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
package com.ciclo3.service;

import com.ciclo3.model.Ortopedic;
import com.ciclo3.repository.OrtopedicRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrtopedicService {
    @Autowired
    private OrtopedicRepository ortopedicRepository;
    
    public List<Ortopedic> getAll(){
        return ortopedicRepository.getAll();
    }
    
    public Optional<Ortopedic> getOrtopedic(int id){
        return ortopedicRepository.getOrtopedic(id);
    }
    
    public Ortopedic save(Ortopedic p){
        if(p.getId()==null){
            return ortopedicRepository.save(p);
        }else{
            Optional<Ortopedic> aux=ortopedicRepository.getOrtopedic(p.getId());
            if(!aux.isPresent()){
                return ortopedicRepository.save(p);
            }else{
                return p;
            }
        }
    }
    
    public Ortopedic update(Ortopedic o){
        if(o.getId()!=null){
            Optional<Ortopedic> e=ortopedicRepository.getOrtopedic(o.getId());
            if(e.isPresent()){
                if(o.getName()!=null){
                    e.get().setName(o.getName());
                }
                if(o.getBrand()!=null){
                    e.get().setBrand(o.getBrand());
                }
                if(o.getYear()!=null){
                    e.get().setYear(o.getYear());
                }
                if(o.getDescription()!=null){
                    e.get().setDescription(o.getDescription());
                }
//                ortopedicRepository.save(e.get());
                return ortopedicRepository.save(e.get());
            }else{
                return o;
            }
        }else{
            return o;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrtopedic(id).map(ortopedic -> {
            ortopedicRepository.delete(ortopedic);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

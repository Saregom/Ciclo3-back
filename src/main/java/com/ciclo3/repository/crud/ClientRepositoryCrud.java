package com.ciclo3.repository.crud;

import com.ciclo3.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepositoryCrud extends CrudRepository<Client, Integer>{
    
}

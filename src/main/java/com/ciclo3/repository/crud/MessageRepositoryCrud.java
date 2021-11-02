package com.ciclo3.repository.crud;

import com.ciclo3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepositoryCrud extends CrudRepository<Message, Integer>{
    
}

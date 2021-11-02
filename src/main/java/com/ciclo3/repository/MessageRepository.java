package com.ciclo3.repository;

import com.ciclo3.model.Message;
import com.ciclo3.repository.crud.MessageRepositoryCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {
    @Autowired
    private MessageRepositoryCrud messageRepositoryCrud;
    
    public List<Message> getAll(){
        return (List<Message>) messageRepositoryCrud.findAll();
    }
    
    public Optional<Message> getMessage(int Id){
        return messageRepositoryCrud.findById(Id);
    }
    
    public Message save(Message m){
        return messageRepositoryCrud.save(m);
    }
    
    public void delete(Message m){
        messageRepositoryCrud.delete(m);
    }
}

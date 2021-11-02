package com.ciclo3.service;

import com.ciclo3.model.Message;
import com.ciclo3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    
    public Message save(Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);
        }else{
            Optional<Message> aux=messageRepository.getMessage(m.getIdMessage());
            if(!aux.isPresent()){
                return messageRepository.save(m);
            }else{
                return m;
            }
        }
    }
    
    public Message update(Message m){
        if(m.getIdMessage()!=null){
            Optional<Message> e=messageRepository.getMessage(m.getIdMessage());
            if(e.isPresent()){
                if(m.getMessageText()!=null){
                    e.get().setMessageText(m.getMessageText());
                }
//                messageRepository.save(e.get());
                return messageRepository.save(e.get());
            }else{
                return m;
            }
        }else{
            return m;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}


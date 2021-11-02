package com.ciclo3.service;

import com.ciclo3.model.Client;
import com.ciclo3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    
    public Client save(Client c){
        if(c.getIdClient()==null){
            return clientRepository.save(c);
        }else{
            Optional<Client> aux=clientRepository.getClient(c.getIdClient());
            if(!aux.isPresent()){
                return clientRepository.save(c);
            }else{
                return c;
            }
        }
    }
    
    public Client update(Client c){
        if(c.getIdClient()!=null){
            Optional<Client> e=clientRepository.getClient(c.getIdClient());
            if(e.isPresent()){
                if(c.getPassword()!=null){
                    e.get().setPassword(c.getPassword());
                }
                if(c.getName()!=null){
                    e.get().setName(c.getName());
                }
                if(c.getAge()!=null){
                    e.get().setAge(c.getAge());
                }
//                clientRepository.save(e.get());
                return clientRepository.save(e.get());
            }else{
                return c;
            }
        }else{
            return c;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

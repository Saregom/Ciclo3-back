package com.ciclo3.repository;

import com.ciclo3.model.Client;
import com.ciclo3.repository.crud.ClientRepositoryCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {
    @Autowired
    private ClientRepositoryCrud clientRepositoryCrud;
    
    public List<Client> getAll(){
        return (List<Client>) clientRepositoryCrud.findAll();
    }
    
    public Optional<Client> getClient(int Id){
        return clientRepositoryCrud.findById(Id);
    }
    
    public Client save(Client c){
        return clientRepositoryCrud.save(c);
    }
    
    public void delete(Client c){
        clientRepositoryCrud.delete(c);
    }
}

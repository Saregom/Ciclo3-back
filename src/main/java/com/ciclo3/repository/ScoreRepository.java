package com.ciclo3.repository;

import com.ciclo3.model.Score;
import com.ciclo3.repository.crud.ScoreRepositoryCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreRepositoryCrud scoreRepositoryCrud;
    
    public List<Score> getAll(){
        return (List<Score>) scoreRepositoryCrud.findAll();
    }
    
    public Optional<Score> getScore(int Id){
        return scoreRepositoryCrud.findById(Id);
    }
    
    public Score save(Score s){
        return scoreRepositoryCrud.save(s);
    }
    
    public void delete(Score s){
        scoreRepositoryCrud.delete(s);
    }
}

package com.ciclo3.service;

import com.ciclo3.model.Score;
import com.ciclo3.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    
    public Score save(Score s){
        if(s.getIdScore()==null){
            return scoreRepository.save(s);
        }else{
            Optional<Score> aux=scoreRepository.getScore(s.getIdScore());
            if(!aux.isPresent()){
                return scoreRepository.save(s);
            }else{
                return s;
            }
        }
    }
    
    public Score update(Score s){
        if(s.getIdScore()!=null){
            Optional<Score> e=scoreRepository.getScore(s.getIdScore());
            if(e.isPresent()){
                if(s.getCalification()!=null){
                    e.get().setCalification(s.getCalification());
                }
                if(s.getMessage()!=null){
                    e.get().setMessage(s.getMessage());
                }
//                scoreRepository.save(e.get());
                return scoreRepository.save(e.get());
            }else{
                return s;
            }
        }else{
            return s;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getScore(id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

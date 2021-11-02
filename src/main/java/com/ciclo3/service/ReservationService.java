package com.ciclo3.service;

import com.ciclo3.model.Client;
import com.ciclo3.model.Reservation;
import com.ciclo3.repository.ReservationRepository;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;  
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> aux=reservationRepository.getReservation(r.getIdReservation());
            if(!aux.isPresent()){
                return reservationRepository.save(r);
            }else{
                return r;
            }
        }
    }
    
    public Reservation update(Reservation r){
        if(r.getIdReservation()!=null){
            Optional<Reservation> e=reservationRepository.getReservation(r.getIdReservation());
            if(e.isPresent()){
                if(r.getStartDate()!=null){
                    e.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(r.getDevolutionDate());
                }
                if(r.getStatus()!=null){
                    e.get().setStatus(r.getStatus());
                }
                return reservationRepository.save(e.get());
            }else{
                return r;
            }
        }else{
            return r;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public List<Reservation> getReportDates(String date1, String date2){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne=new Date();
        Date dateTwo=new Date();
        try {
            dateOne=parser.parse(date1);
            dateTwo=parser.parse(date2);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
            return reservationRepository.getReportDates(dateOne,dateTwo);
        }else{
            return new ArrayList<>();
        }
    }
    
    public AmountStatus getReportStatus(){
        List<Reservation> completed=reservationRepository.getReportStatus("completed");
        List<Reservation> cancelled=reservationRepository.getReportStatus("cancelled");

        return new AmountStatus(completed.size(),cancelled.size());
    }
    public class AmountStatus {
        final private int completed;
        final private int cancelled;

        public AmountStatus(int completed, int cancelled) {
            this.completed = completed;
            this.cancelled = cancelled;
        }
        public int getCompleted() {
            return completed;
        }
        public int getCancelled() {
            return cancelled;
        }
    }
    
    public List<CountClient> getReportClients(){
        List<CountClient> response=new ArrayList<>();

        List<Object[]> report=reservationRepository.getReportClients();
        for(int i=0;i<report.size();i++){
            response.add(new CountClient((Long) report.get(i)[1],(Client)report.get(i)[0]));
        }
        return response;
    }
    public class CountClient {
        final private Long total;
        final private Client client;

        public CountClient(Long total, Client client) {
            this.total = total;
            this.client = client;
        }
        public Long getTotal() {
            return total;
        }
        public Client getClient() {
            return client;
        }
    }
}
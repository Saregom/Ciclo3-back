package com.ciclo3.repository;

import com.ciclo3.model.Reservation;
import com.ciclo3.repository.crud.ReservationRepositoryCrud;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationRepositoryCrud reservationRepositoryCrud;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationRepositoryCrud.findAll();
    }
    
    public Optional<Reservation> getReservation(int Id){
        return reservationRepositoryCrud.findById(Id);
    }
    
    public Reservation save(Reservation r){
        return reservationRepositoryCrud.save(r);
    }
    
    public void delete(Reservation r){
        reservationRepositoryCrud.delete(r);
    }
    
    public List<Reservation> getReportDates(Date date1, Date date2){ 
        return reservationRepositoryCrud.findAllByStartDateAfterAndStartDateBefore(date1, date2);
    }
    
    public List<Reservation> getReportStatus(String status){
        return reservationRepositoryCrud.findAllByStatus(status);
    }
    
    public List<Object[]> getReportClients(){
        return reservationRepositoryCrud.countTotalReservationByClient();
    }
}

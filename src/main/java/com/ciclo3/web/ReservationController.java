package com.ciclo3.web;

import com.ciclo3.model.Reservation;
import com.ciclo3.service.ReservationService;
import com.ciclo3.service.ReservationService.AmountStatus;
import com.ciclo3.service.ReservationService.CountClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation r){
        return reservationService.save(r);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation r) {
        return reservationService.update(r);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int Id) {
        return reservationService.delete(Id);
    }
    
    @GetMapping("/report-dates/{date1}/{date2}")
    public List<Reservation> getReportDates(@PathVariable("date1") String date1, @PathVariable("date2")String date2){
        return reservationService.getReportDates(date1, date2);
    }
    
    @GetMapping("/report-status")
    public AmountStatus getReportStatus(){
        return reservationService.getReportStatus();
    }
    
    @GetMapping("/report-clients")
    public List<CountClient> getReportClients(){
        return reservationService.getReportClients();
    }
}

package com.ciclo3.repository.crud;

import com.ciclo3.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepositoryCrud extends CrudRepository<Reservation, Integer>{
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date date1,Date date2);
    
    public List<Reservation> findAllByStatus(String status);
    
    @Query("select c.client, COUNT(c.client) from Reservation c group by c.client order by COUNT(c.client) desc")
    public List<Object[]> countTotalReservationByClient();
}

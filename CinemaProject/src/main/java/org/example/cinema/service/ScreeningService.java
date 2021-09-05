package org.example.cinema.service;

import org.example.cinema.domain.Film;
import org.example.cinema.domain.Hall;
import org.example.cinema.domain.Screening;
import org.example.cinema.repos.ScreeningRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class ScreeningService {
    @Autowired
    private ScreeningRepo screeningRepo;

    public boolean add(Film film, Hall hall, LocalTime screeningTime, LocalDate screeningDate, int priceOfTicket){
        LocalDateTime localDateTime = LocalDateTime.of(screeningDate, screeningTime);
        if(!findByScreeningDateTimeAndHall(localDateTime, hall.getId())) {
            Screening screening = new Screening();
            screening.setFilm(film);
            screening.setHall(hall);
            screening.setScreeningDateTime(localDateTime);
            screening.setPriceOfTicket(priceOfTicket);
            screeningRepo.save(screening);
            return true;
        }
        return false;
    }

    public boolean edit(Film film, Hall hall, LocalTime screeningTime, LocalDate screeningDate, Screening screening, int priceOfTicket){
        LocalDateTime localDateTime = LocalDateTime.of(screeningDate, screeningTime);
        List<Screening> screenings = screeningRepo.findAll();
        for(Screening s : screenings){
            if(s.getScreeningDateTime().equals(localDateTime) && hall.getId().equals(s.getHall().getId())&&screening.getId().equals(s.getId())){
                screening.setFilm(film);
                screening.setHall(hall);
                screening.setScreeningDateTime(localDateTime);
                screening.setPriceOfTicket(priceOfTicket);
                screeningRepo.save(screening);
                return true;
            }
        }

        if(!findByScreeningDateTimeAndHall(localDateTime, hall.getId())) {
            screening.setFilm(film);
            screening.setHall(hall);
            screening.setScreeningDateTime(localDateTime);
            screeningRepo.save(screening);
            return true;
        }
        return false;
    }

    public boolean delete(Screening screening){
        if(screeningRepo.existsById(screening.getId())) {
            screening.setFilm(null);
            screening.setHall(null);
            screeningRepo.deleteById(screening.getId());
            return true;
        }
        return false;
    }

    public boolean findByScreeningDateTimeAndHall(LocalDateTime screeningDateTime, Long id){
        List<Screening> screenings = screeningRepo.findAll();
        for(Screening s : screenings){
            if(s.getScreeningDateTime().equals(screeningDateTime) && id.equals(s.getHall().getId())){
                return true;
            }
            else if(s.getHall().getId().equals(id)&&s.getScreeningDateTime().toLocalDate().equals(screeningDateTime.toLocalDate())&&(s.getScreeningDateTime().toLocalTime().isBefore(screeningDateTime.toLocalTime())&&s.getScreeningDateTime().toLocalTime().plusMinutes(s.getFilm().getDurationInMinutes()).isAfter(screeningDateTime.toLocalTime()))){
              return true;
            }
        }
        return false;
    }

    public void numOfFreeSeats(){
        List<Screening> screenings = screeningRepo.findAll();
        for(Screening screening:screenings){
            screening.numOfFreeSeats();
            screeningRepo.save(screening);
        }
    }

    public Page<Screening> findAllWithScreeningDateTimeAfterByOrderByScreeningDateTime(Pageable pageable,
                                                                                       @Param("screeningDateTime") LocalDateTime screeningDateTime){
        return screeningRepo.findAllWithScreeningDateTimeAfterByOrderByScreeningDateTime(pageable, screeningDateTime);
    }
}

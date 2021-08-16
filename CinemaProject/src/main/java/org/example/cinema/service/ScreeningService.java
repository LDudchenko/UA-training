package org.example.cinema.service;

import org.example.cinema.domain.Film;
import org.example.cinema.domain.Hall;
import org.example.cinema.domain.Screening;
import org.example.cinema.repos.ScreeningRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.desktop.OpenFilesEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


@Service
public class ScreeningService {
    @Autowired
    private ScreeningRepo screeningRepo;

    public boolean add(Film film, Hall hall, LocalTime screeningTime, LocalDate screeningDate){
        LocalDateTime localDateTime = LocalDateTime.of(screeningDate, screeningTime);

        if(!findByScreeningDateTimeAndHall(localDateTime, hall.getId())) {
            Screening screening = new Screening();
            screening.setFilm(film);
            screening.setHall(hall);
            screening.setScreeningDateTime(localDateTime);
            screeningRepo.save(screening);
            return true;
        }
        return false;
    }

    public boolean edit(Film film, Hall hall, LocalTime screeningTime, LocalDate screeningDate, Screening screening){
        LocalDateTime localDateTime = LocalDateTime.of(screeningDate, screeningTime);
        if(!findByScreeningDateTimeAndHall(localDateTime, hall.getId())) {
            screening.setFilm(film);
            screening.setHall(hall);
            screening.setScreeningDateTime(localDateTime);
            screeningRepo.save(screening);
            return true;
        }
        return false;
    }

    public void delete(Screening screening){
        screeningRepo.deleteById(screening.getId());
    }

    public boolean findByScreeningDateTimeAndHall(LocalDateTime screeningDateTime, Long id){
        List<Screening> screenings = screeningRepo.findAll();
        for(Screening s : screenings){
            if(s.getScreeningDateTime().equals(screeningDateTime) && id.equals(s.getHall().getId())){
                return true;
            }
            else if(s.getHall().getId().equals(id)&&s.getScreeningDateTime().toLocalDate().equals(screeningDateTime.toLocalDate())&&(s.getScreeningDateTime().toLocalTime().isBefore(screeningDateTime.toLocalTime())&&s.getScreeningDateTime().toLocalTime().plusMinutes(120L).isAfter(screeningDateTime.toLocalTime()))){
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
}

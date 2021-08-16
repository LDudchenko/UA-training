package org.example.cinema.service;

import org.example.cinema.domain.Hall;
import org.example.cinema.repos.HallRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService {
    @Autowired
    HallRepo hallRepo;

    public List<Hall> findAll(){
        return  hallRepo.findAll();
    }

    public void delete(Hall hall){
        hallRepo.deleteById(hall.getId());
    }

    public void add(String name, int numOfRows, int numOfSeatsAtRow){
        Hall hall = new Hall();

        hall.setName(name);
        hall.setNumOfRows(numOfRows);
        hall.setNumOfSeatsAtRow(numOfSeatsAtRow);

        hallRepo.save(hall);
    }

    public void save(String name, int numOfRows, int numOfSeatsAtRow, Hall hall){
        hall.setName(name);
        hall.setNumOfRows(numOfRows);
        hall.setNumOfSeatsAtRow(numOfSeatsAtRow);

        hallRepo.save(hall);
    }
}

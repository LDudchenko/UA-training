package org.example.cinema.controller;

import lombok.SneakyThrows;
import org.example.cinema.domain.Film;
import org.example.cinema.domain.Hall;
import org.example.cinema.repos.FilmRepo;
import org.example.cinema.repos.HallRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/halls")
public class HallController {
    @Autowired
    private HallRepo hallRepo;

    @GetMapping
    public String hallList(Model model){
        model.addAttribute("halls", hallRepo.findAll());
        System.out.println(hallRepo.findAll().size());
        return "hallList";
    }

    @GetMapping("{hall}")
    public String hallEditForm(@PathVariable Hall hall, Model model){
        model.addAttribute("hall", hall);
        return "hallEdit";
    }

    @GetMapping("/add")
    public String addHallPage(){
        return "addHall";
    }

    @PostMapping("/add")
    public String addHall(@RequestParam String name,
                          @RequestParam int numOfRows,
                          @RequestParam int numOfSeatsAtRow){
        Hall hall = new Hall();

        hall.setName(name);
        hall.setNumOfRows(numOfRows);
        hall.setNumOfSeatsAtRow(numOfSeatsAtRow);

        hallRepo.save(hall);

        return "redirect:/halls";
    }

    @GetMapping("/delete/{hall}")
    public String hallDelete(@PathVariable Hall hall){
        hallRepo.deleteById(hall.getId());
        return "redirect:/halls";
    }

    @PostMapping
    public String hallSave(
            @RequestParam String name,
            @RequestParam int numOfRows,
            @RequestParam int numOfSeatsAtRow,
            @RequestParam("hallId") Hall hall){

        hall.setName(name);
        hall.setNumOfRows(numOfRows);
        hall.setNumOfSeatsAtRow(numOfSeatsAtRow);

        hallRepo.save(hall);

        return "redirect:/halls";
    }
}


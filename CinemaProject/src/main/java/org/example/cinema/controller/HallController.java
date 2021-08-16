package org.example.cinema.controller;

import org.example.cinema.domain.Hall;
import org.example.cinema.repos.HallRepo;
import org.example.cinema.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/halls")
public class HallController {
    @Autowired
    private HallRepo hallRepo;

    @Autowired
    private HallService hallService;

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
        hallService.add(name, numOfRows, numOfSeatsAtRow);
        return "redirect:/halls";
    }

    @GetMapping("/delete/{hall}")
    public String hallDelete(@PathVariable Hall hall){
        hallService.delete(hall);
        return "redirect:/halls";
    }

    @PostMapping
    public String hallSave(
            @RequestParam String name,
            @RequestParam int numOfRows,
            @RequestParam int numOfSeatsAtRow,
            @RequestParam("hallId") Hall hall){

        hallService.save(name, numOfRows, numOfSeatsAtRow, hall);
        return "redirect:/halls";
    }
}


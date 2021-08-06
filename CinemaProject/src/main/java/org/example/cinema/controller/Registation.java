package org.example.cinema.controller;

import org.example.cinema.domain.Role;
import org.example.cinema.domain.User;
import org.example.cinema.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Controller
public class Registation {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser( User user, Map<String, Object> model){
        Optional<User> userFromDb = userRepo.findUserByUsername(user.getUsername());

       if(userFromDb != null){
           model.put("message", "User exists!");
           return "registration";
       }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }

}

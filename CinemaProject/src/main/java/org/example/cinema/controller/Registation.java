package org.example.cinema.controller;

import org.example.cinema.domain.Role;
import org.example.cinema.domain.User;
import org.example.cinema.repos.UserRepo;
import org.example.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class Registation {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model){
//        Optional<User> userFromDb = userRepo.findUserByUsername(user.getUsername());

        userService.addUser(user);
        if(bindingResult.hasErrors()){
           //Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
           //model.mergeAttributes(errors );
            model.addAttribute("noErrors", true);
           return "registration";
        }
//
//       if(userFromDb != null){
//           model.addAttribute("usernameError", "User exists!");
//           return "registration";
//       }
//
//        user.setActive(true);
//        user.setRoles(Collections.singleton(Role.USER));
//        userRepo.save(user);

        return "redirect:/login";
    }

}

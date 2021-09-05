package org.example.cinema.service;

import org.example.cinema.domain.Role;
import org.example.cinema.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.cinema.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findUserByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("user " + username + " was not found!"));
    }

    public boolean addUser(User user){
        Optional<org.example.cinema.domain.User> userFromDB = userRepo.findUserByUsername(user.getUsername());
        if(userFromDB.isPresent()) {
            return false;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepo.save(user);

        return true;
    }

    public int topUpAccount(User user, int sum){
        Optional<User> userFromDB = userRepo.findById(user.getId());
        if(userFromDB.isPresent()){
            userFromDB.get().setAccount(userFromDB.get().getAccount()+sum);
            userRepo.save(user);
            return userFromDB.get().getAccount();
        }
        return -1;
    }

}

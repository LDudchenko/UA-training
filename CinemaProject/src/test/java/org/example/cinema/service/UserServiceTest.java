package org.example.cinema.service;

import org.example.cinema.domain.Role;
import org.example.cinema.domain.User;
import org.example.cinema.repos.UserRepo;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepo userRepo;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    public void addUser() {
        User user = new User();
        boolean isUserCreated = userService.addUser(user);
        Assert.assertTrue(isUserCreated);
        Assert.assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.USER)));
        Mockito.verify(userRepo, Mockito.times(1)).save(user);
        userRepo.delete(user);
    }

    @Test
    public void addUserFailTest(){
        User user = new User();

        user.setUsername("dasha");

        Mockito.doReturn(Optional.of(new User())).when(userRepo).findUserByUsername("dasha");
        boolean isUserCreated = userService.addUser(user);
        Assert.assertFalse(isUserCreated);
        Mockito.verify(userRepo, Mockito.times(0)).save(user);

    }


    @Test
    public void loadByUserName(){
        User user = new User();
        Mockito.when(userRepo.findUserByUsername("dasha")).thenReturn(Optional.of(user));
        assertEquals(user, userService.loadUserByUsername("dasha"));
    }

    @Test(expected = UsernameNotFoundException.class)
    public void loadByUserNameFailTest(){
        Mockito.when(userRepo.findUserByUsername("dasha")).thenReturn(Optional.ofNullable(null));
        userService.loadUserByUsername("dasha");
    }
}
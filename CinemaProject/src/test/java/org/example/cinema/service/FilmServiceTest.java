package org.example.cinema.service;

import org.example.cinema.domain.Film;
import org.example.cinema.domain.Screening;
import org.example.cinema.repos.FilmRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class FilmServiceTest {
//    @Autowired
//    FilmService filmService;
//
//    @Autowired
//    FilmRepo filmRepo;
//
////    @Test
////    public void delete(){
////        Film film = new Film();
////        film.setId(1L);
////        FilmRepo mock = org.mockito.Mockito.mock(FilmRepo.class);
////        Mockito.when(mock.existsById(film.getId())).thenReturn(true);
////        assertTrue(filmService.delete(film));
////        Mockito.verify(mock, Mockito.times(1)).deleteById(film.getId());
////    }
////
////    @Test
////    public void deleteFailTest(){
////        Film film = new Film();
////        film.setId(1L);
////        Mockito.when(filmRepo.existsById(film.getId())).thenReturn(false);
////        assertFalse(filmService.delete(film));
////        Mockito.verify(filmRepo, Mockito.times(0)).deleteById(film.getId());
////    }
////
////    @Test
////    public void add(){
////        Film film = new Film();
////        filmService.add("Залізна людина", "Iron man", "Опис", "Description");
////        Mockito.verify(filmRepo, Mockito.times(1)).save(ArgumentMatchers.any());
////    }
//
//}
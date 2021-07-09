package com.company.controller;

/**
 * Created by Dudchenko Liudmila on 08.07.2021
 */
public class AlreadyExistedLogin extends Exception{
    public AlreadyExistedLogin(){
        super("Such login is already exists!");
    }
}

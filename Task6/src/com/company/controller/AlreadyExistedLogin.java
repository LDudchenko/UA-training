package com.company.controller;

public class AlreadyExistedLogin extends Exception{
    public AlreadyExistedLogin(){
        super("Such login is already exists!");
    }
}

package com.portfolio.sms.security.controller;

public class Mensaje {
    private String mensaje;

    //constructor

    public Mensaje(){

    }

    public Mensaje(String mensaje){
        this.mensaje = mensaje;
    }
    //Getter y Setter


    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

package com.cdm.javafxpersonal.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Configuracion {
    @Bean("lblTitulo")
    private String titulo(){
        return "Bienvenido a Spring y Javafx";
    }
}

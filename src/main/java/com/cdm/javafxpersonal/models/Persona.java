package com.cdm.javafxpersonal.models;

import javax.persistence.*;

@Entity
@Table(name="persona")
public class Persona {

    @Id
    private String cedula;
    @Column
    private String nombre;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

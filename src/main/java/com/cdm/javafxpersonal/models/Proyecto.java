package com.cdm.javafxpersonal.models;

import javax.persistence.*;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idProyecto;
    @Column
    private String nombreProyecto;

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long id) {
        this.idProyecto = id;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    @Override
    public String toString() {
        return nombreProyecto;
    }
}

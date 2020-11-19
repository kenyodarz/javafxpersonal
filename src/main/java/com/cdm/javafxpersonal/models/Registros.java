package com.cdm.javafxpersonal.models;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Registros {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "cedula")
    private Persona persona;
    @OneToOne
    @JoinColumn(name = "idProyecto")
    private Proyecto proyecto;
    @Column
    private Date fecha;
    @Column
    private LocalTime horaEntrada;
    @Column
    private LocalTime horaSalida;
    @Column
    private double horaOrdinaria;
    @Column
    private double recargoNocturno;
    @Column
    private double horaExtra;
    @Column
    private double horaExtraNocturna;
    @Column
    private double horaExtraFestiva;
    @Column
    private double HoraExtraFestivaNocturna;

    public Registros() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getHoraOrdinaria() {
        return horaOrdinaria;
    }

    public void setHoraOrdinaria(double horaOrdinaria) {
        this.horaOrdinaria = horaOrdinaria;
    }

    public double getRecargoNocturno() {
        return recargoNocturno;
    }

    public void setRecargoNocturno(double recargoNocturno) {
        this.recargoNocturno = recargoNocturno;
    }

    public double getHoraExtra() {
        return horaExtra;
    }

    public void setHoraExtra(double horaExtra) {
        this.horaExtra = horaExtra;
    }

    public double getHoraExtraNocturna() {
        return horaExtraNocturna;
    }

    public void setHoraExtraNocturna(double horaExtraNocturna) {
        this.horaExtraNocturna = horaExtraNocturna;
    }

    public double getHoraExtraFestiva() {
        return horaExtraFestiva;
    }

    public void setHoraExtraFestiva(double horaExtraFestiva) {
        this.horaExtraFestiva = horaExtraFestiva;
    }

    public double getHoraExtraFestivaNocturna() {
        return HoraExtraFestivaNocturna;
    }

    public void setHoraExtraFestivaNocturna(double getHoraExtraFestivaNocturna) {
        this.HoraExtraFestivaNocturna = getHoraExtraFestivaNocturna;
    }
}

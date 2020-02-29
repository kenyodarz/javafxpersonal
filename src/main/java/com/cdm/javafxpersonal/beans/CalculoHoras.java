package com.cdm.javafxpersonal.beans;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CalculoHoras {
    /* Declaracion de variables no modificar */
    private int hora;
    private int minuto;
    private final int segundo =0;
    private int festivo;
    private final String[] horas = {
            "0","1","2","3","4","5","6","7","8","9","10","11","12",
            "13","14","15","16","17","18","19","20","21","22","23"};
    private final String[] minutos = { "0","30","59" };
    private double recargosnocturos = 0;
    private double horasordinarias = 0;
    private double horasExtrasOrdinarias = 0;
    private double horasExtrasNocturnas = 0;
    private double horasExtrasOrdinariasFestivas = 0;
    private double horasExtrasNocturnasFestivas = 0;
    final String formatoHora = "HH:mm:ss";


    final LocalTime rn1 = LocalTime.of(21, 0, segundo);
    final LocalTime rn2 = LocalTime.of(23, 59, segundo);
    final LocalTime rn3 = LocalTime.of(0, 0, segundo);
    final LocalTime rn4 = LocalTime.of(6, 0, segundo);

    public CalculoHoras() {
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public int getFestivo() {
        return festivo;
    }

    public void setFestivo(int festivo) {
        this.festivo = festivo;
    }

    public String[] getHoras() {
        return horas;
    }

    public String[] getMinutos() {
        return minutos;
    }

    public double getRecargosnocturos() {
        return recargosnocturos;
    }

    public void setRecargosnocturos(double recargosnocturos) {
        this.recargosnocturos = recargosnocturos;
    }

    public double getHorasordinarias() {
        return horasordinarias;
    }

    public void setHorasordinarias(double horasordinarias) {
        this.horasordinarias = horasordinarias;
    }

    public double getHorasExtrasOrdinarias() {
        return horasExtrasOrdinarias;
    }

    public void setHorasExtrasOrdinarias(double horasExtrasOrdinarias) {
        this.horasExtrasOrdinarias = horasExtrasOrdinarias;
    }

    public double getHorasExtrasNocturnas() {
        return horasExtrasNocturnas;
    }

    public void setHorasExtrasNocturnas(double horasExtrasNocturnas) {
        this.horasExtrasNocturnas = horasExtrasNocturnas;
    }

    public double getHorasExtrasOrdinariasFestivas() {
        return horasExtrasOrdinariasFestivas;
    }

    public void setHorasExtrasOrdinariasFestivas(double horasExtrasOrdinariasFestivas) {
        this.horasExtrasOrdinariasFestivas = horasExtrasOrdinariasFestivas;
    }

    public double getHorasExtrasNocturnasFestivas() {
        return horasExtrasNocturnasFestivas;
    }

    public void setHorasExtrasNocturnasFestivas(double horasExtrasNocturnasFestivas) {
        this.horasExtrasNocturnasFestivas = horasExtrasNocturnasFestivas;
    }

    public String getFormatoHora() {
        return formatoHora;
    }

    public LocalTime getRn1() {
        return rn1;
    }

    public LocalTime getRn2() {
        return rn2;
    }

    public LocalTime getRn3() {
        return rn3;
    }

    public LocalTime getRn4() {
        return rn4;
    }

    public void calcularHoras(int horaIngreso, int minutoEntrada, int horaSalid , int minutoSalida, int festivo ) {
        DateTimeFormatter timeColonFormatter = DateTimeFormatter.ofPattern(formatoHora);
        LocalTime horaEntrada = LocalTime.of(horaIngreso, minutoEntrada, this.segundo);
        LocalTime horaSalida = LocalTime.of(horaSalid, minutoSalida, this.segundo);
        for (LocalTime i = horaEntrada; (i.isBefore(horaSalida)); i = i.plusMinutes(30)){
            if(festivo==0){
                if((i.equals(this.rn3)&&(this.horasExtrasNocturnasFestivas!=0)&&(this.horasExtrasOrdinariasFestivas!=0))){
                    break;
                }else {
                    if((i.isBefore(this.rn4)||i.equals(this.rn4))&&i.isAfter(this.rn3)){
                        this.horasExtrasNocturnasFestivas += 0.5;

                    }else if(i.isBefore(this.rn2) && (i.isAfter(this.rn1)||(i.equals(this.rn1)))){
                        this.horasExtrasNocturnasFestivas += 0.5;

                    }else{
                        this.horasExtrasOrdinariasFestivas+=0.5;
                    }
                }
            }
            else{
                if((i.equals(this.rn3)&&(this.recargosnocturos!=0)&&(this.horasordinarias!=0))){
                    break;
                }else if((this.recargosnocturos+this.horasordinarias)<8){
                    if((i.isBefore(this.rn4)||i.equals(this.rn4))&&i.isAfter(this.rn3)){
                        this.recargosnocturos += 0.5;

                    }else if(i.isBefore(this.rn2) && (i.isAfter(this.rn1)||(i.equals(this.rn1)))){
                        this.recargosnocturos += 0.5;

                    }else{
                        this.horasordinarias+=0.5;
                    }
                }else{
                    if((i.isBefore(this.rn4)||i.equals(this.rn4))&&i.isAfter(this.rn3)){
                        this.horasExtrasNocturnas += 0.5;

                    }else if(i.isBefore(this.rn2) && (i.isAfter(this.rn1)||(i.equals(this.rn1)))){
                        this.horasExtrasNocturnas += 0.5;

                    }else{
                        this.horasExtrasOrdinarias+=0.5;
                    }

                }
            }

        }
    }
}

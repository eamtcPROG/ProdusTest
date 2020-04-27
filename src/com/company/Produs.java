package com.company;

import java.time.LocalDate;
import java.time.LocalTime;

public class Produs {
    private String nume;
    private double pretDeAchizitie;
    private double pretDeVanzare;
    private LocalDate dataDeExpirare;
    private String descrierea;

    public void setNume(String pNume){
        this.nume = pNume;
    }
    public void setPretDeAchizitie(double pPretDeAchizitie){
        this.pretDeAchizitie = pPretDeAchizitie;
    }
    public void setPretDeVanzare(double pPretDeVanzare){
        this.pretDeVanzare = pPretDeVanzare;
    }
    public void setDataDeExpirare(LocalDate pData){
        this.dataDeExpirare = pData;
    }
    public void setDescrierea(String pDescrierea){
        this.descrierea = pDescrierea;
    }

    public String getNume(){
        return this.nume;
    }
    public double getPretDeAchizitie(){
        return this.pretDeAchizitie;
    }
    public double getPretDeVanzare(){
        return this.pretDeVanzare;
    }
    public LocalDate getDataDeExpirare() { return this.dataDeExpirare;   }
    public String getDescrierea() { return this.descrierea;  }
}

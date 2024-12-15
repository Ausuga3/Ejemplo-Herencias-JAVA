package com.aluraCursos.screenmatch.modelos;

import com.aluraCursos.screenmatch.calculos.Clasificacion;

public class Episodio implements Clasificacion {
    private int numero;
    private String nombre;
    private Serie serie;
    private int totalVisualizacione;

    public int getTotalVisualizacione() {
        return totalVisualizacione;
    }

    public void setTotalVisualizacione(int totalVisualizacione) {
        this.totalVisualizacione = totalVisualizacione;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClasificacion() {
        if (totalVisualizacione > 100){
            return 4;
        }else{
            return 2;
        }
    }
}

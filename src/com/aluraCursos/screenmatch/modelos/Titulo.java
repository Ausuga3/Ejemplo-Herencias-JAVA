package com.aluraCursos.screenmatch.modelos;

import com.aluraCursos.screenmatch.excepcion.ErrorEnConversionDeDuracionExeption;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    @SerializedName("Title")
    private String nombre;
    @SerializedName("Year")
    private int fechaDeLanzamiento;
    private int duracionMinutos;
    private boolean incluidoEnElPlan;
    private double sumaEvaluaciones;
    private int totalEvaluaciones;

    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Titulo(TituloOmbd miTituloOmbd) {
        this.nombre = miTituloOmbd.title();
        this.fechaDeLanzamiento = Integer.valueOf(miTituloOmbd.year());
        if (miTituloOmbd.runtime().contains("N/A")){
            throw new ErrorEnConversionDeDuracionExeption("No pude convertir la duracion, "
                    + "porque tiene un N/A");
        }
        this.duracionMinutos = Integer.valueOf(miTituloOmbd.runtime().substring(0,3).replace( " ", ""));
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public int getTotalEvaluaciones(){
        return totalEvaluaciones;
    }


    public void muestraFichaTecnica(){
        System.out.println("Pelicula: " + nombre);
        System.out.println("Su fecha de lanzamiento es: " + fechaDeLanzamiento);
        System.out.println("Duracion: " + getDuracionMinutos() + " minutos" );
    }

    public void evalua(double nota){
        sumaEvaluaciones += nota;
        totalEvaluaciones ++;
    }

    public double calculaMedia(){
        return sumaEvaluaciones / totalEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" + "Fecha De Lanzamiento: " + fechaDeLanzamiento +
                "\nDuracion: " + duracionMinutos + " Minutos";
    }
}

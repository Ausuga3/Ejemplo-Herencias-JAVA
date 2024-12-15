package com.aluraCursos.screenmatch.calculos;

public class Recomendacion {
    public void filtra(Clasificacion clasificacion){
        if (clasificacion.getClasificacion() >= 4){
            System.out.println("Muy bien evaluado en el momento");
        } else if (clasificacion.getClasificacion() >=2 ){
            System.out.println("Popular en el momento");
        }else{
            System.out.println("agregalo en tu lista para ver despues");
        }
    }
}

package com.aluraCursos.screenmatch.Principal;

import com.aluraCursos.screenmatch.modelos.Pelicula;
import com.aluraCursos.screenmatch.modelos.Serie;
import com.aluraCursos.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas {
    public static void main(String[] args) {


        Pelicula miPelicula = new Pelicula("Encanto",  2021);
        miPelicula.evalua(9);
        Pelicula otraPelicula =new Pelicula("Matrix" ,  1999);
        otraPelicula.evalua(8);
        var peliculaDeBruno = new Pelicula("El Señor de los anillos",  2001);
        peliculaDeBruno.evalua(10);
        var PeliculaAndres = new Pelicula("Avengers", 2012);
        PeliculaAndres.evalua(10);
        Serie casaDragon = new Serie("House of dragon", 2022);
        casaDragon.evalua(9);
        var lost = new Serie("Lost", 2004);
        lost.evalua(8);

        List<Titulo> lista = new LinkedList<>();
        lista.add(peliculaDeBruno);
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(PeliculaAndres);
        lista.add(lost);
        lista.add(casaDragon);

        for (Titulo item : lista) {
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
                System.out.println("Clasificacion: " + pelicula.getClasificacion());
            }
        }

        ArrayList<String> listaActores = new ArrayList<>();
        listaActores.add("Keanu Reeves");
        listaActores.add("Hugo Weaving");
        listaActores.add("Carrie-Anne Moss");
        listaActores.add("Reachel mcAdams");

        Collections.sort(listaActores);
        System.out.println("Lista Actores: " + listaActores);

        Collections.sort(lista);
        System.out.println("titulos ordenados alfabeticamente: " + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Titulos orden fecha: " + lista);
    }
}

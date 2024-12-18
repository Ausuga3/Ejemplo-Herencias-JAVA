import com.aluraCursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluraCursos.screenmatch.calculos.Recomendacion;
import com.aluraCursos.screenmatch.modelos.Episodio;
import com.aluraCursos.screenmatch.modelos.Pelicula;
import com.aluraCursos.screenmatch.modelos.Serie;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto",  2021);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(5.1);
        System.out.println("Media de evaluaciones de la pelicula: "+ miPelicula.calculaMedia());


        Serie casaDragon = new Serie("House of dragon", 2022);
        casaDragon.setTemporadas(2);
        casaDragon.setMinutosEpisodio(50);
        casaDragon.setEpisodiosTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println(casaDragon.getDuracionMinutos());

        Pelicula otraPelicula =new Pelicula("Matrix" ,  1999);

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo necesario para ver tus titulos seleccionados " + calculadora.getTiempoTotal() + " minutos");

        Recomendacion filtroRecomendacion  = new Recomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("la casa targerian");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizacione(50);
        filtroRecomendacion.filtra(episodio);



        var peliculaDeBruno = new Pelicula("El Señor de los anillos",  2001);
        var PeliculaAndres = new Pelicula("Avengers", 2012);


        ArrayList<Pelicula> listaPelicula = new ArrayList<>();
        listaPelicula.add(peliculaDeBruno);
        listaPelicula.add(miPelicula);
        listaPelicula.add(otraPelicula);
        listaPelicula.add(PeliculaAndres);


        System.out.println("Tamaño de la lista: " + listaPelicula.size());
        System.out.println("La primera pelicula es: " + listaPelicula.get(0).getNombre());
        System.out.println(listaPelicula.toString());

        System.out.println("toString de la pelicula: "+ listaPelicula.get(0).toString());

















    }
}

import com.aluraCursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluraCursos.screenmatch.calculos.Recomendacion;
import com.aluraCursos.screenmatch.modelos.Episodio;
import com.aluraCursos.screenmatch.modelos.Pelicula;
import com.aluraCursos.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula();
        miPelicula.setNombre("Encanto");
        miPelicula.setFechaDeLanzamiento(2021);
        miPelicula.setDuracionMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(5.1);
        System.out.println("Media de evaluaciones de la pelicula: "+ miPelicula.calculaMedia());


        Serie casaDragon = new Serie();
        casaDragon.setNombre("House of dragon");
        casaDragon.setFechaDeLanzamiento(2022);
        casaDragon.setTemporadas(2);
        casaDragon.setMinutosEpisodio(50);
        casaDragon.setEpisodiosTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println(casaDragon.getDuracionMinutos());

        Pelicula otraPelicula =new Pelicula();
        otraPelicula.setNombre("Matrix");
        otraPelicula.setFechaDeLanzamiento(1998);
        otraPelicula.setDuracionMinutos(180);

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













    }
}

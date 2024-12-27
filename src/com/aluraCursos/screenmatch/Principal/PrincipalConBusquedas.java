package com.aluraCursos.screenmatch.Principal;

import com.aluraCursos.screenmatch.excepcion.ErrorEnConversionDeDuracionExeption;
import com.aluraCursos.screenmatch.modelos.Titulo;
import com.aluraCursos.screenmatch.modelos.TituloOmbd;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusquedas {
    public static void main(String[] args) throws IOException, InterruptedException {



        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la pelicula");
        var busqueda = lectura.nextLine();


        String direccion = "http://www.omdbapi.com/?t=" +
                busqueda.replace(" ", "+") +
                "&apikey=7107d44a";


        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);


            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

            TituloOmbd miTituloOmbd = gson.fromJson(json, TituloOmbd.class);
            System.out.println(miTituloOmbd);


            Titulo miTitulo = new Titulo(miTituloOmbd);
            System.out.println("Titulo ya convertido \n" + miTitulo);

            FileWriter escritura = new FileWriter("peliculas.txt");
            escritura.write(gson.toJson(miTitulo));
            escritura.close();

        }catch (ErrorEnConversionDeDuracionExeption e) {
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e) {
            System.out.println("Error en la URI, verifique la direccion");

        }catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());

        }





    }
}

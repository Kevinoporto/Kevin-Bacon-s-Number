package imdb;

import java.util.ArrayList;

public class Pelicula {
    private String titulo;
    private ArrayList<Actor> actores;

    public Pelicula(String titulo, ArrayList<Actor> actores) {
        this.titulo = titulo;
        this.actores = actores;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setActores(ArrayList<Actor> actores) {
        this.actores = actores;
    }

    public static Pelicula buscarPelicula(String titulo, ArrayList<Pelicula> peliculas) {
        return peliculas.stream().filter(pelicula -> titulo.equals(pelicula.getTitulo()))
                .findAny()
                .orElse(null);
    }
}

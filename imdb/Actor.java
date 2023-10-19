package imdb;

import java.util.ArrayList;

public class Actor {
  private String nombre;
  private ArrayList<Pelicula> listaPeliculas;

  public Actor(String nombre, ArrayList<Pelicula> listaPeliculas) {
    this.nombre = nombre;
    this.listaPeliculas = listaPeliculas;
  }

  public ArrayList<Pelicula> getListaPeliculas() {
    return listaPeliculas;
  }

  public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
    this.listaPeliculas = listaPeliculas;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public static Actor buscarActor(String nombre, ArrayList<Actor> actores) {
    return actores.stream().filter(actor -> nombre.equals(actor.getNombre()))
        .findAny()
        .orElse(null);
  }
}

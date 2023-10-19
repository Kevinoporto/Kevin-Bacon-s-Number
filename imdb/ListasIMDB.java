package imdb;

import java.util.ArrayList;

public class ListasIMDB {
  private ArrayList<Actor> listaActores;
  private ArrayList<Pelicula> listaPeliculas;

  public ListasIMDB(ArrayList<Actor> listaActores, ArrayList<Pelicula> listaPeliculas) {
    this.listaActores = listaActores;
    this.listaPeliculas = listaPeliculas;
  }

  public ArrayList<Actor> getListaActores() {
    return listaActores;
  }

  public ArrayList<Pelicula> getListaPeliculas() {
    return listaPeliculas;
  }

  public void setListaActores(ArrayList<Actor> listaActores) {
    this.listaActores = listaActores;
  }

  public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
    this.listaPeliculas = listaPeliculas;
  }
}

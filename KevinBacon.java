import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import imdb.Actor;
import imdb.ListasIMDB;
import imdb.Pelicula;
import tad_grafo.GrafoNoDirigido;
import tad_grafo.Vertice;

public class KevinBacon {
    /*
     * Se lee la entrada y se generan 3 listas: 
     * ListaActores: Contiene una lista donde esta el nombre de cada actor/actriz y una lista de peliculas protagonizadas por el actor/actirz i.
     * ListaPeliculas: Contiene una lista de peliculas y cada pelicula, tiene asignada una lista de actores que participaron en esa pelicula.
     * Lista IMDB: Es una lista que tiene las dos listas anteriores
     * Pre-Condicion: Correcto formato de entrada con actores y peliculas como se describe en el enunciado.
     * Post-Condicion: Retorna una lista de peliculas y actores, como se describio anteriormente.
     */ 
    private static ListasIMDB convertirInput(String path) {
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
        ArrayList<Actor> listaActores = new ArrayList<>();
        FileReader archivo;
        BufferedReader lector;
        try {
            archivo = new FileReader(path);
            if (archivo.ready()) {
                lector = new BufferedReader(archivo);
                String linea;
                while ((linea = lector.readLine()) != null) {
                    String[] frases = linea.split("\\|");
                    String titulo = frases[1];
                    String nombreActor = frases[0];

                    Actor actorActual = Actor.buscarActor(nombreActor, listaActores);
                    if (actorActual == null) {
                        actorActual = new Actor(nombreActor, new ArrayList<>());
                        listaActores.add(actorActual);
                    }

                    Pelicula peliculaActual = Pelicula.buscarPelicula(titulo, listaPeliculas);
                    if (peliculaActual == null) {
                        ArrayList<Actor> actores = new ArrayList<>();
                        actores.add(actorActual);
                        peliculaActual = new Pelicula(titulo, actores);
                        listaPeliculas.add(peliculaActual);
                    } else {
                        ArrayList<Actor> actores = peliculaActual.getActores();
                        actores.add(actorActual);
                    }

                    actorActual.getListaPeliculas().add(peliculaActual);
                }
            } else {
                System.out.print("Error");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        ListasIMDB nuevaListaIMDB = new ListasIMDB(listaActores, listaPeliculas);
        return nuevaListaIMDB;
    }

    /*
     * Se crea el grafo donde el id de cada vertice, es el nombre del actor/actriz
     * y en el peso se almacenara el NKB que al crear el grafo sera 0 para todos los vertices.
     *  
     */
    private static GrafoNoDirigido crearGrafo(ListasIMDB listaIMDB) {
        GrafoNoDirigido grafo = GrafoNoDirigido.crearGrafoNoDirigido();
        ArrayList<Actor> actores = listaIMDB.getListaActores();

        for (Actor actor : actores)
            grafo.agregarVertice(actor.getNombre(), 0);

        /*
         * Se verifica si un actor tiene alguna pelicula en relacion con otro y si la hay se crea una arista entre ellos.
         * Pre-Condicion: ListaIMDB no vacia
         * Post-Condicion: Grafo de Actores/Actrices.
         */
        for (Actor actor : actores) {
            for (Pelicula pelicula : actor.getListaPeliculas()) {
                for (Actor participante : pelicula.getActores()) {
                    if (!actor.getNombre().equals(participante.getNombre())) {
                        String arcoId = String.format("%s-%s:%s", pelicula.getTitulo(), actor.getNombre(),
                                participante.getNombre());
                        grafo.agregarArista(arcoId, 0, actor.getNombre(), participante.getNombre());
                    }
                }
            }
        }
        return grafo;
    }
    
    public static void main(String[] args) {
        /*
         * Se lee la entrada y se crea el grafo y se coloca el vertice con id Kevin Bacon(I) como nodo de entrada al grafo.
         */
        ListasIMDB listasIMDB = convertirInput(args[0]);
        GrafoNoDirigido grafo = crearGrafo(listasIMDB);
        int indiceNodoRaiz = 0;
        for (Vertice vertice : grafo.vertices()) {
            if (vertice.getId().equals("Kevin Bacon (I)")) {
                indiceNodoRaiz = grafo.vertices().indexOf(vertice);
                break;
            }
        }
        /*
         * Se buscan los caminos con BFS desde el vertice de Kevin Bacon.
         */
        List<List<Vertice>> caminosBFS = GrafoNoDirigido.BFS(grafo, indiceNodoRaiz);

        /*
         * El ultimo vertice de un camino tendra un NKB igual al tamaño del camino.
         */
        for (List<Vertice> camino : caminosBFS) {
            camino.get(camino.size()-1).setPeso(camino.size()-1);
        }
        /*
         * Se buscan los vertices con NKB = 0 que no sea Kevin Bacon y se les asigna un peso(NKB) de -1
         */
        for (Vertice vertice: grafo.vertices()){
            if((!vertice.getId().equals("Kevin Bacon (I)")) && 
            (vertice.getPeso() == 0)){
                vertice.setPeso(-1);
            }
        }
        /*
         * Se imprimen todos los vertices con su respectivo NKB y si NKB=-1 se imprime "infinito"
         */
        double mayorPeso = 0;
        for (Vertice vertice : grafo.vertices()){
            if (vertice.getPeso() > mayorPeso){
                mayorPeso = vertice.getPeso();
            }
        
            if (vertice.getPeso() == -1){
                System.out.println(vertice.getId() +" : "+ "infinito");
            }else{
                System.out.println(vertice.getId() +" : "+  vertice.getPeso());
            }
            
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("El actor / actriz con mayor numero de Kevin Bacon es: ");
        for (Vertice vertice : grafo.vertices()){
            if (vertice.getPeso() == mayorPeso){
                System.out.println(vertice.getId()+", con un NKB de: "+ vertice.getPeso());
            }
        }
    }
}

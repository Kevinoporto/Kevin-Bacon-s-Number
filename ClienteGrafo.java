import java.util.List;

import tad_grafo.Digrafo;
import tad_grafo.Vertice;

/**
 *
 */

public class ClienteGrafo {
  public static void main(String[] args) {
    Digrafo D = Digrafo.crearDigrafo();

    D.cargarGrafo("./test.txt");

    /*
     * List<Vertice> vertices = D.vertices();
     * System.out.println("Adyacentes: ");
     * for (Vertice vertice : vertices) {
     * System.out.printf("%s: ", vertice.getId());
     * List<Vertice> adyacentes = D.adyacentes(vertice.getId());
     * for (Vertice adyacente : adyacentes) {
     * System.out.printf("%s ", adyacente.getId());
     * }
     * System.out.println();
     * }
     */

    List<List<Vertice>> caminosBfs = Digrafo.BFS(D);
    for (List<Vertice> camino : caminosBfs) {
      for (Vertice vertice : camino) {
        System.out.printf("%s ", vertice.getId());
      }
      System.out.println();
    }
  }
}
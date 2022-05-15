package com.Programacion.pr2;

import java.util.*;

public class Graph<V> {

    // Lista de adyacencia.
    private Map<Vertice<V>, Set<Vertice<V>>> adjacencyList = new HashMap<>();

    // Voy a hacer el metodo getter PARA PRUEBAS
    public Map<Vertice<V>, Set<Vertice<V>>> getAdjacencyList() {
        return adjacencyList;
    }

    /******************************************************************
     * Añade el vértice ` v` al grafo.
     * @ param v vértice a añadir.
     * @ return ` true` si no estaba anteriormente y ` false` en caso
     * contrario.
     ******************************************************************/
    public boolean addVertex(Vertice<V> v) {

        Set<Vertice<V>> set = new HashSet<Vertice<V>>();
        adjacencyList.put(v, set);

        return true;
    }

    /******************************************************************
     * Añ ade un arco entre los vé rtices ` v1` y ` v2` al grafo. En
     * caso de que no exista alguno de los vé rtices, lo añ ade
     * tambié n.
     *
     * @ param v1 el origen del arco.
     * @ param v2 el destino del arco.
     * @ return ` true` si no existí a el arco y ` false` en caso contrario.
     ******************************************************************/
    public boolean addEdge(V v1, V v2) {
        return true; // Este código hay que modificarlo.
    }

    /******************************************************************
     * Obtiene el conjunto de vé rtices adyacentes a ` v`.
     *
     * @ param v vé rtice del que se obtienen los adyacentes.
     * @ return conjunto de vé rtices adyacentes.
     ******************************************************************/
    public Set<V> obtainAdjacents(V v) throws Exception {
        return null; // Este código hay que modificarlo.
    }

    /******************************************************************
     * Comprueba si el grafo contiene el vé rtice dado.
     *
     * @ param v vé rtice para el que se realiza la comprobació n.
     * @ return ` true` si ` v` es un vé rtice del grafo.
     ******************************************************************/
    public boolean containsVertex(Vertice<V> v) {

        boolean isVertex;
        isVertex = adjacencyList.containsKey(v);
        return isVertex;

    }

    /******************************************************************
     * Mé todo ` toString()` reescrito para la clase ` Grafo. java`.
     * @ return una cadena de caracteres con la lista de
     * adyacencia.
     ******************************************************************/
    @Override
    public String toString() {
        return ""; // Este código hay que modificarlo.
    }

    /**
     * Obtiene, en caso de que exista, el camino má s corto entre
     * ` v1` y ` v2`. En caso contrario, devuelve ` null`.
     *
     * @ param v1 el vé rtice origen.
     * @ param v2 el vé rtice destino.
     * @ return lista con la secuencia de vé rtices del camino má s corto
     * entre ` v1` y ` v2`
     */
    public List<V> shortestPath(V v1, V v2) {
        return null; // Esto código hay que modificarlo.
    }
}

package com.Programacion.pr2;

import java.util.*;

public class Graph<V> {

    // Lista de adyacencia.
    private Map<Vertice<V>, Set<Vertice<V>>> adjacencyList = new HashMap<>();
    private Stack<Vertice<V>> pila = new Stack<>();
    private List<Stack<Vertice<V>>> caminosEncontrados = new ArrayList<>();

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
        boolean isVertex;
        if (adjacencyList.containsKey(v)) {
            isVertex = false;
        } else {
            Set<Vertice<V>> nuevoSet = new HashSet<>();
            adjacencyList.put(v, nuevoSet);
            isVertex = true;
        }
        return isVertex;
    }

    /******************************************************************
     * Añade un arco entre los vértices ` v1` y ` v2` al grafo. En
     * caso de que no exista alguno de los vértices, lo añade
     * también.
     *
     * @ param v1 el origen del arco.
     * @ param v2 el destino del arco.
     * @ return ` true` si no existía el arco y ` false` en caso contrario.
     ******************************************************************/
    public boolean addEdge(Vertice<V> v1, Vertice<V> v2) {
        boolean isCorrecto = false;
        try {
            if (!this.containsVertex(v1) && !this.containsVertex(v2)) {
                this.addVertex(v1);
                adjacencyList.get(v1).add(v2);
                this.addVertex(v2);
                adjacencyList.get(v2).add(v1);
            } else if (this.containsVertex(v1) && !this.containsVertex(v2)) {
                this.addVertex(v2);
                adjacencyList.get(v2).add(v1);
                adjacencyList.get(v1).add(v2);
            } else if (this.containsVertex(v1) && this.containsVertex(v2)) {
                adjacencyList.get(v2).add(v1);
                adjacencyList.get(v1).add(v2);
            } else {
                isCorrecto = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isCorrecto;
    }

    /******************************************************************
     * Obtiene el conjunto de vértices adyacentes a ` v`.
     *
     * @ param v vértice del que se obtienen los adyacentes.
     * @ return conjunto de vé rtices adyacentes.
     ******************************************************************/
    public Set<Vertice<V>> obtainAdjacents(Vertice<V> v) throws Exception {

        // Buscamos el conjunto de nodos adyacentes a v
        Set<Vertice<V>> set = new HashSet<>();
        if (this.containsVertex(v)) {
            set = adjacencyList.get(v);
        }
        if (set.isEmpty()) {
            throw new Exception("El vértice no tiene adyacentes o el vértice no está en el grafo");
        }
        return set;
    }

    /******************************************************************
     * Comprueba si el grafo contiene el vé rtice dado.
     *
     * @ param v vé rtice para el que se realiza la comprobació n.
     * @ return ` true` si ` v` es un vé rtice del grafo.
     ******************************************************************/
    public boolean containsVertex(Vertice<V> v) {

        boolean esta = false;
        // Lo implemento asi que un vértice es distinto de in vértice no visitado
        // - Un vértice no vistado tiene el mismo id que un visitado
        // . Un vértice no visitado difiere de visitado en el atributo isVisited.
        for (Map.Entry<Vertice<V>, Set<Vertice<V>>> entry : adjacencyList.entrySet()) {
            if (entry.getKey().getid().equals(v.getid())) {
                esta = true;
            }
        }
        return esta;
    }

    /******************************************************************
     * Mé todo ` toString()` reescrito para la clase ` Grafo. java`.
     * @ return una cadena de caracteres con la lista de
     * adyacencia.
     ******************************************************************/
    @Override
    public String toString() {

        ArrayList<String> adyacentes = new ArrayList<>();
        Set<Vertice<V>> nodoSet;
        StringBuilder cadenaAdyacentes = new StringBuilder();
        StringBuilder cadena = new StringBuilder();

        for (Map.Entry<Vertice<V>, Set<Vertice<V>>> entry : adjacencyList.entrySet()) {
            nodoSet = (Set<Vertice<V>>) entry.getValue();
            for (Vertice v : nodoSet) {
                cadenaAdyacentes.append((v.getid().toString()));
                cadenaAdyacentes.append(" ");
            }
            cadena.append("Vertice: ");
            cadena.append(((Vertice) entry.getKey()).getid());
            cadena.append("Vertices adyacentes: ");
            cadena.append(cadenaAdyacentes);
            cadena.append("\n");
            adyacentes.add(cadena.toString());
            cadenaAdyacentes.delete(0, cadenaAdyacentes.length());
            cadena.delete(0, cadena.length());
        }
        Collections.sort(adyacentes);

        for (String cad : adyacentes) {
            cadena.append(cad);
        }
        return cadena.toString();
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
    public List<Vertice<V>> shortestPath(Vertice<V> from, Vertice<V> to) {
        Set<Vertice<V>> set;

        try{
            pila.push(from);
            from.setisVisited(true);
            set= obtainAdjacents(from);

            for(Vertice<V> vertice : set){
                if(vertice == to){
                    //Tengo que quitar la pila y montar una List<Version>>
                    pila.push(vertice);
                    Stack<Vertice<V>>nuevoCamino = new Stack<>();
                    nuevoCamino.addAll(pila);
                    caminosEncontrados.add(nuevoCamino);
                    System.out.println("Camino encontrado" + pila);
                    pila.pop();
                    break;
                }  else if (!vertice.getisVisited()){
                    System.out.println("Buscando camino.");
                    shortestPath(vertice, to);
                    pila.pop();
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return this.dameCaminoMinimo();
    }

    private Stack<Vertice<V>> dameCaminoMinimo(){

        Stack<Vertice<V>> caminoMinimo = null;
        try{
            caminoMinimo = caminosEncontrados.get(0);
            for(Stack<Vertice<V>> camino: caminosEncontrados){
                if(caminoMinimo.size() > camino.size()){
                    caminoMinimo= camino;
                }
            }
        }catch(IndexOutOfBoundsException ex){
            System.out.println("No ha sido posible encontrar un camino mínimo aun...");
        }
        return caminoMinimo;
    }
}

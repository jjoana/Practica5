package com.Programacion.principal;

import com.Programacion.pr2.*;

public class App {
    
    public static void main(String args[]){

        Graph<Integer> grafo = new Graph<Integer>();
        Vertice<Integer> v1 = new Vertice<Integer>(1, false);
        Vertice<Integer> v2 = new Vertice<Integer>(2, false);
        Vertice<Integer> v3 = new Vertice<Integer>(3, false);
        Vertice<Integer> v4 = new Vertice<Integer>(4, false);
        Vertice<Integer> v5 = new Vertice<Integer>(5, false);
        Vertice<Integer> v6 = new Vertice<Integer>(6, false);
        Vertice<Integer> v7 = new Vertice<Integer>(7, false);
        Vertice<Integer> v8 = new Vertice<Integer>(8, false);
        Vertice<Integer> v9 = new Vertice<Integer>(9, false);
        grafo.addEdge(v1, v2);
        grafo.addEdge(v1, v3);
        grafo.addEdge(v2, v4);
        grafo.addEdge(v2, v5);
        grafo.addEdge(v3, v5);
        grafo.addEdge(v3, v7);
        grafo.addEdge(v5, v6);
        grafo.addEdge(v6, v7);
        grafo.addEdge(v7, v8);
        grafo.addEdge(v7, v9);

        System.out.println("Ruta minima encontrada entre vertices: " + grafo.shortestPath(v1, v9));

    }
}

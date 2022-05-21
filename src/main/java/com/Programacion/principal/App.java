package com.Programacion.principal;

import com.Programacion.pr2.*;

public class App {
    
    public static void main(String args[]){

        Graph<Integer> grafo = new Graph<Integer>();
        Vertice<Integer> v1 = new Vertice<Integer>(1, false);
        Vertice<Integer> v2 = new Vertice<Integer>(2, false);
        Vertice<Integer> v3 = new Vertice<Integer>(3, false);
        Vertice<Integer> v4 = new Vertice<Integer>(4, false);
        grafo.addVertex(v1);
        grafo.addVertex(v2);
        grafo.addVertex(v3);
        grafo.addEdge(v1, v2);
        grafo.addEdge(v1, v3);
        grafo.addEdge(v2, v3);


        System.out.println("Esta vertice v1: " + grafo.containsVertex(v1));
        System.out.println("Esta vertice v2: " + grafo.containsVertex(v2));
        System.out.println("Esta vertice v3: " + grafo.containsVertex(v3));
        System.out.println("Esta vertice v4: " + grafo.containsVertex(v4));

    }
}

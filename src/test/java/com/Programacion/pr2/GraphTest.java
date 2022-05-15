package com.Programacion.pr2;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GraphTest{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void addVertexTest(){

        Vertice<Integer> v1 = new Vertice<Integer>(1,false);
        Vertice<Integer> v2 = new Vertice<Integer>(2,false);
        Vertice<Integer> v3 = new Vertice<Integer>(3,false);
        Graph<Integer> grafo = new Graph<Integer>();
        grafo.addVertex(v1);
        grafo.addVertex(v2);
        grafo.addVertex(v3);
        Map<Vertice<Integer>, Set<Vertice<Integer>>> adjacencyList;
        adjacencyList = grafo.getAdjacencyList();

        assertTrue( adjacencyList.containsKey(v1) );
        assertTrue( adjacencyList.containsKey(v2) );
        assertTrue( adjacencyList.containsKey(v3) );
    }

        /**
     * Rigorous Test :-)
     */
    @Test
    public void containsVertexTest(){

        Vertice<Integer> v1 = new Vertice<Integer>(1,false);
        Vertice<Integer> v2 = new Vertice<Integer>(2,false);
        Vertice<Integer> v3 = new Vertice<Integer>(3,false);
        Vertice<Integer> v4 = new Vertice<Integer>(4,false);
        Graph<Integer> grafo = new Graph<Integer>();
        grafo.addVertex(v1);
        grafo.addVertex(v2);
        grafo.addVertex(v3);

        assertTrue( grafo.containsVertex(v1) );
        assertTrue( grafo.containsVertex(v2) );
        assertTrue( grafo.containsVertex(v3));
        assertFalse ( grafo.containsVertex(v4));
    }
}

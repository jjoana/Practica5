package com.Programacion.pr2;


import static org.junit.Assert.assertEquals;


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
    public void shortestPathFindsApath(){

        Vertice<Integer> v1 = new Vertice<Integer>(1,false);
        Vertice<Integer> v2 = new Vertice<Integer>(2,false);
        Vertice<Integer> v3 = new Vertice<Integer>(3,false);
        Vertice<Integer> v4 = new Vertice<Integer>(4,false);
        Vertice<Integer> v5 = new Vertice<Integer>(5,false);
        Graph<Integer> grafo = new Graph<Integer>();
        grafo.addEdge(v1, v2);
        grafo.addEdge(v1, v5);
        grafo.addEdge(v2, v3);
        grafo.addEdge(v3, v4);
        grafo.addEdge(v5, v4);

        Map<Vertice<Integer>, Set<Vertice<Integer>>> adjacencyList;
        adjacencyList = grafo.getAdjacencyList();

        //We build the expected path
        List<Vertice<Integer>> expectedPath = new ArrayList<>();
        expectedPath.add(v1);
        expectedPath.add(v5);
        expectedPath.add(v4);
        //We check if returned path is equal to the expected one
        assertEquals(expectedPath, grafo.shortestPath(v1,v4));
    }
}

package datastructures.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    private Graph<String> graph;

    @BeforeEach
    public void setUp() {
        graph = new Graph<>(10);
    }

    @Test
    public void testAddVertex() {
        Vertex<String> vertex = graph.addVertex("Test");
        assertNotNull(vertex);
        assertEquals(1, graph.size());
    }

    @Test
    public void testAddEdge() {
        Vertex<String> vertex1 = graph.addVertex("Test1");
        Vertex<String> vertex2 = graph.addVertex("Test2");
        graph.addEdge(vertex1, vertex2, 1);

        LinkedList<Edge<String>> neighbors = graph.getNeighbors(vertex1);
        assertNotNull(neighbors);
        assertEquals(1, neighbors.size());
        assertEquals(vertex2, neighbors.get(0).destination);
    }

    @Test
    public void testGetVertices() {
        Vertex<String> vertex1 = graph.addVertex("Test1");
        Vertex<String> vertex2 = graph.addVertex("Test2");

        LinkedList<Vertex<String>> vertices = graph.getVertices();
        assertNotNull(vertices);
        assertEquals(2, vertices.size());
        assertTrue(vertices.contains(vertex1));
        assertTrue(vertices.contains(vertex2));
    }

    @Test
    public void testGetNeighbors() {
        Vertex<String> vertex1 = graph.addVertex("Test1");
        Vertex<String> vertex2 = graph.addVertex("Test2");
        graph.addEdge(vertex1, vertex2, 1);

        LinkedList<Edge<String>> neighbors = graph.getNeighbors(vertex1);
        assertNotNull(neighbors);
        assertEquals(1, neighbors.size());
        assertEquals(vertex2, neighbors.get(0).destination);
        assertEquals(1, neighbors.get(0).weight);
    }

    @Test
    public void testSize() {
        Vertex<String> vertex1 = graph.addVertex("Test1");
        Vertex<String> vertex2 = graph.addVertex("Test2");
        assertEquals(2, graph.size());
    }

    @Test
    public void testSingleNodeAndEdgeGraph() {
        Graph<String> singleNodeGraph = new Graph<>(1);
        Vertex<String> singleVertex = singleNodeGraph.addVertex("Single");
        singleNodeGraph.addEdge(singleVertex, singleVertex, 0);

        assertEquals(1, singleNodeGraph.size());
        LinkedList<Vertex<String>> vertices = singleNodeGraph.getVertices();
        assertTrue(vertices.contains(singleVertex));

        LinkedList<Edge<String>> edges = singleNodeGraph.getNeighbors(singleVertex);
        assertNotNull(edges);
        assertEquals(1, edges.size());
        assertEquals(singleVertex, edges.get(0).destination);
        assertEquals(0, edges.get(0).weight);
    }

    @Test
    public void testBreadthFirstEmpty() {
        Graph<Integer> graph = new Graph<>(1);
        List<Vertex<Integer>> result = graph.breadthFirst();
        assertEquals(0, result.size());
    }

    @Test
    public void testBreadthFirstSingle() {
        Graph<String> graph = new Graph<>(1);
        graph.addVertex("A");
        List<Vertex<String>> result = graph.breadthFirst();
        assertEquals(1, result.size());
        assertEquals("A", result.get(0).value);
    }

    @Test
    public void testBreadthFirstMultiple() {
        Graph<Character> graph = new Graph<>(1  );
        graph.addEdge(new Vertex<>('A'), new Vertex<>('B'));
        graph.addEdge(new Vertex<>('A'), new Vertex<>('C'));
        graph.addEdge(new Vertex<>('B'), new Vertex<>('D'));
        graph.addEdge(new Vertex<>('C'), new Vertex<>('E'));
        graph.addEdge(new Vertex<>('C'), new Vertex<>('F'));
        List<Vertex<Character>> result = graph.breadthFirst();
        assertEquals(6, result.size());
        assertEquals('A', result.get(0).value);
        assertEquals('B', result.get(1).value);
        assertEquals('C', result.get(2).value);
        assertEquals('D', result.get(3).value);
        assertEquals('E', result.get(4).value);
        assertEquals('F', result.get(5).value);

    }
}
package datastructures.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

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
}
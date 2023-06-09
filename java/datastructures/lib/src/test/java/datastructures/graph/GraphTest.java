package datastructures.graph;

import codechallenges.linkedlist.GraphBusinessTrip;
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

    @Test
    public void testBusinessTripWithDirectFlights() {
        Graph<String> graph = new Graph<>(3);
        graph.addEdge(new Vertex<>("Arendelle"), new Vertex<>("New Monstropolis"), 42);
        graph.addEdge(new Vertex<>("New Monstropolis"), new Vertex<>("Naboo"), 73);

        GraphBusinessTrip trip = new GraphBusinessTrip();

        String[] cities = {"Arendelle", "New Monstropolis", "Naboo"};
        Integer result = trip.businessTrip(graph, cities);

        assertEquals(Integer.valueOf(115), result);
    }

    @Test
    public void testBusinessTripWithMissingCity() {
        Graph<String> graph = new Graph<>(4);
        graph.addEdge(new Vertex<>("Arendelle"), new Vertex<>("New Monstropolis"), 42);
        graph.addEdge(new Vertex<>("New Monstropolis"), new Vertex<>("Naboo"), 73);

        GraphBusinessTrip trip = new GraphBusinessTrip();

        String[] cities = {"Arendelle", "New Monstropolis", "Naboo", "Las Vegas"};
        Integer result = trip.businessTrip(graph, cities);


        assertEquals(null, result);
    }

    @Test
    public void testBusinessTripWithNoDirectFlight() {
        Graph<String> graph = new Graph<>(4);
        graph.addEdge(new Vertex<>("Arendelle"), new Vertex<>("New Monstropolis"), 42);
        graph.addEdge(new Vertex<>("Arendelle"), new Vertex<>("Pandora"), 150);
        graph.addEdge(new Vertex<>("Pandora"), new Vertex<>("Naboo"), 108);

        GraphBusinessTrip trip = new GraphBusinessTrip();

        String[] cities = {"Arendelle", "New Monstropolis", "Naboo"};
        Integer result = trip.businessTrip(graph, cities);

        // There is no direct flight from Portland to Los Angeles, so the result should be null
        assertEquals(null, result);
    }

    @Test
    public void testGraphWithLinearStructure() {
        Graph<Character> graph = new Graph<>(5);
        Vertex<Character> vertexA = graph.addVertex('A');
        Vertex<Character> vertexB = graph.addVertex('B');
        Vertex<Character> vertexC = graph.addVertex('C');
        Vertex<Character> vertexD = graph.addVertex('D');
        Vertex<Character> vertexE = graph.addVertex('E');

        graph.addEdge(vertexA, vertexB);
        graph.addEdge(vertexB, vertexC);
        graph.addEdge(vertexC, vertexD);
        graph.addEdge(vertexD, vertexE);

        List<Vertex<Character>> traversalOrder = graph.depthFirst(vertexA);

// Test assertions
        assert traversalOrder.get(0).getValue() == 'A';
        assert traversalOrder.get(1).getValue() == 'B';
        assert traversalOrder.get(2).getValue() == 'C';
        assert traversalOrder.get(3).getValue() == 'D';
        assert traversalOrder.get(4).getValue() == 'E';
    }

    @Test
    public void testGraphWithDisconnects() {
        Graph<Character> graph = new Graph<>(8);
        Vertex<Character> vertexA = graph.addVertex('A');
        Vertex<Character> vertexB = graph.addVertex('B');
        Vertex<Character> vertexC = graph.addVertex('C');
        Vertex<Character> vertexD = graph.addVertex('D');
        Vertex<Character> vertexE = graph.addVertex('E');
        Vertex<Character> vertexF = graph.addVertex('F');
        Vertex<Character> vertexG = graph.addVertex('G');
        Vertex<Character> vertexH = graph.addVertex('H');

        graph.addEdge(vertexA, vertexB);
        graph.addEdge(vertexB, vertexC);
        graph.addEdge(vertexC, vertexD);
        graph.addEdge(vertexE, vertexF);
        graph.addEdge(vertexF, vertexG);
        graph.addEdge(vertexG, vertexH);

        List<Vertex<Character>> traversalOrder = graph.depthFirst(vertexA);

// Test assertions
        assert traversalOrder.get(0).getValue() == 'A';
        assert traversalOrder.get(1).getValue() == 'B';
        assert traversalOrder.get(2).getValue() == 'C';
        assert traversalOrder.get(3).getValue() == 'D';
        assert traversalOrder.get(4).getValue() == 'E';
        assert traversalOrder.get(5).getValue() == 'F';
        assert traversalOrder.get(6).getValue() == 'G';
        assert traversalOrder.get(7).getValue() == 'H';
    }

    @Test
    public void testGraphWithBranchingStructure() {
        Graph<Character> graph = new Graph<>(9);
        Vertex<Character> vertexA = graph.addVertex('A');
        Vertex<Character> vertexB = graph.addVertex('B');
        Vertex<Character> vertexC = graph.addVertex('C');
        Vertex<Character> vertexD = graph.addVertex('D');
        Vertex<Character> vertexE = graph.addVertex('E');
        Vertex<Character> vertexF = graph.addVertex('F');
        Vertex<Character> vertexG = graph.addVertex('G');
        Vertex<Character> vertexH = graph.addVertex('H');
        Vertex<Character> vertexI = graph.addVertex('I');

        graph.addEdge(vertexA, vertexB);
        graph.addEdge(vertexA, vertexC);
        graph.addEdge(vertexB, vertexD);
        graph.addEdge(vertexB, vertexE);
        graph.addEdge(vertexC, vertexF);
        graph.addEdge(vertexC, vertexG);
        graph.addEdge(vertexE, vertexH);
        graph.addEdge(vertexE, vertexI);

        List<Vertex<Character>> traversalOrder = graph.depthFirst(vertexA);

// Test assertions
        assert traversalOrder.get(0).getValue() == 'A';
        assert traversalOrder.get(1).getValue() == 'B';
        assert traversalOrder.get(2).getValue() == 'C';
        assert traversalOrder.get(3).getValue() == 'F';
        assert traversalOrder.get(4).getValue() == 'G';
        assert traversalOrder.get(5).getValue() == 'D';
        assert traversalOrder.get(6).getValue() == 'E';
        assert traversalOrder.get(7).getValue() == 'H';
        assert traversalOrder.get(8).getValue() == 'I';
    }
}
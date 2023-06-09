package datastructures.graph;

import java.util.*;

public class Graph<T extends Comparable<? super T>> implements Comparable<Graph<T>>
{
    public HashMap<Vertex<T>, LinkedList<Edge<T>>> adjacencyLists;
    private int numberOfVertices = 0;

    public Graph(int maxNumberOfVertices)
    {
        adjacencyLists = new HashMap<>(maxNumberOfVertices);
    }

    public Vertex<T> addVertex(T value) {
        Vertex<T> newVertex = new Vertex<>(value);
        if (!adjacencyLists.containsKey(newVertex)) {
            adjacencyLists.put(newVertex, new LinkedList<>());
            numberOfVertices++;
        }

        return newVertex;
    }

    public void addEdge(Vertex<T> start, Vertex<T> destination)
    {
        addEdge(start, destination, 0);
    }

    public void addEdge(Vertex<T> start, Vertex<T> destination, int weight) {
        if (!adjacencyLists.containsKey(start) || !adjacencyLists.containsKey(destination)) {
            throw new IllegalArgumentException("Both nodes must exist in the graph");
        }
        adjacencyLists.get(start).add(new Edge<T>(destination, weight));
    }

    public LinkedList<Vertex<T>> getVertices()  // getNodes()
    {
        return new LinkedList<>(adjacencyLists.keySet());
    }

    public LinkedList<Edge<T>> getNeighbors(Vertex<T> vertex)
    {
        if (!adjacencyLists.containsKey(vertex)) {
            throw new IllegalArgumentException("The vertex does not exist in the graph");
        }

        return adjacencyLists.get(vertex);
    }

    public int size()
    {
        return numberOfVertices;
    }

    public List<Vertex<T>> breadthFirst() {
        List<Vertex<T>> orderVisited = new ArrayList<>();
        Queue<Vertex<T>> queue = new LinkedList<>();
        Set<Vertex<T>> visited = new HashSet<>();

        List<Vertex<T>> vertices = getVertices();
        if (vertices.isEmpty()) {
            return orderVisited;
        }

        for (Vertex<T> vertex : vertices) {
            if (!visited.contains(vertex)) {
                queue.add(vertex);
                visited.add(vertex);

                while (!queue.isEmpty()) {
                    Vertex<T> current = queue.poll();
                    orderVisited.add(current);
                    LinkedList<Edge<T>> neighbors = getNeighbors(current);
                    if (neighbors != null) {
                        for (Edge<T> edge : neighbors) {
                            Vertex<T> neighbor = edge.destination;
                            if (!visited.contains(neighbor)) {
                                queue.add(neighbor);
                                visited.add(neighbor);
                            }
                        }
                    }
                }
            }
        }

        for (Vertex<T> vertex : orderVisited) {
            System.out.println(vertex.value);
        }

        return orderVisited;
    }

    public List<Vertex<T>> depthFirst(Vertex<T> start) {
        List<Vertex<T>> traversalOrder = new ArrayList<>();
        Set<Vertex<T>> visited = new HashSet<>();

        depthFirstTraversal(start, visited, traversalOrder);

        for (Vertex<T> vertex : traversalOrder) {
            System.out.println(vertex.value);
        }

        return traversalOrder;
    }

    private void depthFirstTraversal(Vertex<T> current, Set<Vertex<T>> visited, List<Vertex<T>> traversalOrder) {
        visited.add(current);
        traversalOrder.add(current);

        LinkedList<Edge<T>> neighbors = getNeighbors(current);
        if (neighbors != null) {
            for (Edge<T> edge : neighbors) {
                Vertex<T> neighbor = edge.destination;
                if (!visited.contains(neighbor)) {
                    depthFirstTraversal(neighbor, visited, traversalOrder);
                }
            }
        }
    }


    @Override
    public int compareTo(Graph<T> o)
    {
        throw new UnsupportedOperationException("Graph does not implement compareTo()");
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (Vertex<T> vertex : adjacencyLists.keySet()) {
            sb.append(vertex.value).append(" -> ");
            for (Edge<T> edge : adjacencyLists.get(vertex)) {
                sb.append(edge.destination.value).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

package datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<T> {
    private Map<T, Set<T>> adjacencyList;
    private boolean isDirected;

    public Graph(boolean isDirected) {
        this.adjacencyList = new HashMap<>();
        this.isDirected = isDirected;
    }

    public void addVertex(T vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    public void addEdge(T from, T to) {
        addVertex(from);
        addVertex(to);

        adjacencyList.get(from).add(to);

        if (!isDirected) {
            adjacencyList.get(to).add(from);
        }
    }

    public Set<T> getNeighbours(T vertex) {
        return adjacencyList.getOrDefault(vertex, new HashSet<>());
    }

    public boolean hasVertex(T vertex) {
        return adjacencyList.containsKey(vertex);
    }

    public boolean hasEdge(T from, T to) {
        return getNeighbours(from).contains(to);
    }

    public int getVertexCount() {
        return adjacencyList.size();
    }

    public int getEdgeCount() {
        int count = 0;
        for (Set<T> neighbors : adjacencyList.values()) {
            count += neighbors.size();
        }

        return isDirected ? count : count / 2;
    }

    public boolean removeEdge (T from, T to) {
        if (!hasVertex(from) || !hasVertex(to)) {
            return false;
        }

        if (!hasEdge(from, to)) {
            return false;
        }

        adjacencyList.get(from).remove(to);

        if (!isDirected) {
            adjacencyList.get(to).remove(from);
        }

        return true;
    }

    public boolean removeVertex(T vertex) {
        if (!hasVertex(vertex)) {
            return false;
        }

        if (!isDirected) {
            Set<T> neighbors = adjacencyList.get(vertex);

            neighbors.forEach((neighbor) -> {
                adjacencyList.get(neighbor).remove(vertex);
            });
        } else {
            for (Set<T> neighbors : adjacencyList.values()) {
                neighbors.remove(vertex);
            }
        }

        adjacencyList.remove(vertex);

        return true;
    }
}

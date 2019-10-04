package my.aaa;

import java.util.*;

public class DirectedGraph<T> implements Graph<T> {
    Map<T, LinkedList<T>> graph = new HashMap<>();

    private boolean step(T next, T stop, Set<T> visited, Stack<Edge<T>> result) {
        if (next.equals(stop)) {
            return true;
        }
        visited.add(next);

        if (graph.containsKey(next)) {
            for (T vertex : graph.get(next)) {
                if (!visited.contains(vertex)) {
                    result.add(new Edge<>(next, vertex));
                    if (step(vertex, stop, visited, result)) {
                        return true;
                    }
                }
            }
        }
        if (!result.empty()) {
            result.pop();
        }
        return false;
    }

    public void addVertex(T vertex) {
        if (!graph.containsKey(vertex)) {
            graph.put(vertex, new LinkedList<>());
        }
    }

    public void addEdge(Edge<T> edge) {
        addVertex(edge.getSource());
        graph.get(edge.getSource()).add(edge.getDest());
    }

    @Override
    public List<Edge<T>> getPath(T start, T end) {
        Set<T> visited = new HashSet<>();
        Stack<Edge<T>> result = new Stack<>();
        step(start, end, visited, result);
        return result;
    }
}

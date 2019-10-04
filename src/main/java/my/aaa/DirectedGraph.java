package my.aaa;

import java.util.List;

public class DirectedGraph<T> implements Graph<T> {
    public void addVertex(T vertex) {

    }
    public void addEdge(Edge<T> edge) {

    }

    private static class Vertex<T> {

        Vertex(T vertex) {
        }
    }

    @Override
    public List<Edge<T>> getPath(T start, T end) {
        return null;
    }
}

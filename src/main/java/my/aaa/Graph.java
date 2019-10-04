package my.aaa;

import java.util.List;

public interface Graph<T> {

    void addVertex(T vertex);

    void addEdge(Edge<T> edge);

    List<Edge<T>> getPath(T start, T end);

}

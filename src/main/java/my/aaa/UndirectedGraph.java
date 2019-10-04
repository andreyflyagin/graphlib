package my.aaa;

public class UndirectedGraph<T> extends DirectedGraph<T>{
    @Override
    public void addEdge(Edge<T> edge) {
        super.addEdge(edge);

        addVertex(edge.getDest());
        graph.get(edge.getDest()).add(edge.getSource());
    }
}

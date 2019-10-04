package my.aaa;

public class GraphApp {
    static public void run() {
        DirectedGraph<Integer> directedGraph = new DirectedGraph<>();

        Integer v1 = new Integer(1);
        Integer v2 = new Integer(2);
        Integer v3 = new Integer(3);

        directedGraph.addEdge(new Edge<>(v1, v2));
        directedGraph.addEdge(new Edge<>(v2, v3));


    }
}

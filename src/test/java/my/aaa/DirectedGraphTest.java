package my.aaa;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class DirectedGraphTest {

    @Test
    public void getPath() {
        /*
            0->1->3->4->7
                \
                 ->2->5->6
         */
        Graph<Integer> graph = new DirectedGraph<>();

        graph.addEdge(new Edge<>(0, 1));
        graph.addEdge(new Edge<>(1, 2));
        graph.addEdge(new Edge<>(1, 3));
        graph.addEdge(new Edge<>(3, 4));
        graph.addEdge(new Edge<>(2, 5));
        graph.addEdge(new Edge<>(5, 6));
        graph.addEdge(new Edge<>(4, 7));

        List<Edge<Integer>> expected = Arrays.asList(
                new Edge<>(0, 1),
                new Edge<>(1, 3),
                new Edge<>(3, 4),
                new Edge<>(4, 7)
        );

        assertEquals(expected, graph.getPath(0, 7));

        assertTrue(graph.getPath(2, 1).isEmpty());

        List<Edge<Integer>> expected3 = Arrays.asList(
                new Edge<>(0, 1),
                new Edge<>(1, 2),
                new Edge<>(2, 5)
        );
        assertEquals(expected3, graph.getPath(0, 5));

        /*
            7
         */

        Graph<Integer> graph1 = new DirectedGraph<>();
        graph.addVertex(7);

        assertTrue(graph1.getPath(12, 33).isEmpty());
        assertTrue(graph1.getPath(7, 7).isEmpty());

        /*
            0->1->2->3->1
            33
        */

        Graph<Integer> graph2 = new DirectedGraph<>();
        graph2.addEdge(new Edge<>(0, 1));
        graph2.addEdge(new Edge<>(1, 2));
        graph2.addEdge(new Edge<>(2, 3));
        graph2.addEdge(new Edge<>(3, 1));
        graph2.addVertex(33);

        List<Edge<Integer>> expected2 = Arrays.asList(
                new Edge<>(0, 1),
                new Edge<>(1, 2),
                new Edge<>(2, 3)
        );

        assertEquals(expected2, graph2.getPath(0, 3));
        assertTrue(graph2.getPath(0, 33).isEmpty());

        /*

        */
        Graph<Integer> graph3 = new DirectedGraph<>();
        assertTrue(graph3.getPath(0, 12).isEmpty());

        /*
            0->0=>1
         */
        Graph<Integer> graph4 = new DirectedGraph<>();
        graph4.addEdge(new Edge<>(0, 0));
        graph4.addEdge(new Edge<>(0, 1));
        graph4.addEdge(new Edge<>(0, 1));
        assertTrue(graph4.getPath(0, 0).isEmpty());

        List<Edge<Integer>> expected4 = Collections.singletonList(
                new Edge<>(0, 1)
        );

        assertEquals(expected4, graph4.getPath(0, 1));
    }
}

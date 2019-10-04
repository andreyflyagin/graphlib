package my.aaa;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UndirectedGraphTest {

    @Test
    public void getPath() {
         /*
            0--1--3--4--7
                \
                 --2--5--6
         */
        Graph<Integer> graph = new UndirectedGraph<>();

        graph.addEdge(new Edge<>(0, 1));
        graph.addEdge(new Edge<>(1, 2));
        graph.addEdge(new Edge<>(1, 3));
        graph.addEdge(new Edge<>(3, 4));
        graph.addEdge(new Edge<>(2, 5));
        graph.addEdge(new Edge<>(5, 6));

        // reversed edge
        graph.addEdge(new Edge<>(7, 4));

        List<Edge<Integer>> expected = Arrays.asList(
                new Edge<>(0, 1),
                new Edge<>(1, 3),
                new Edge<>(3, 4),
                new Edge<>(4, 7)
        );

        assertEquals(expected, graph.getPath(0, 7));
    }
}

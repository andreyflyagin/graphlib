package my.aaa;

public class Edge<T> {
    final T source, dest;

    Edge(T source, T dest) {
        this.source = source;
        this.dest = dest;
    }

    public static <T> Edge of(T source, T dest) {
        return new Edge<>(source, dest);
    }
}

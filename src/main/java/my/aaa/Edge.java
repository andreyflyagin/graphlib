package my.aaa;

import java.util.Objects;

public class Edge<T> {
    private final T source, dest;

    Edge(T source, T dest) {
        this.source = source;
        this.dest = dest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return Objects.equals(source, edge.source) &&
                Objects.equals(dest, edge.dest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, dest);
    }

    @Override
    public String toString() {
        return "Edge(" + source + ", dest=" + dest +')';
    }

    public T getSource() {
        return source;
    }

    public T getDest() {
        return dest;
    }
}

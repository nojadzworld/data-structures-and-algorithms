package datastructures.graph;

import java.util.Objects;

public class Vertex<T extends Comparable<? super T>> implements Comparable<Vertex<T>>
{
    public T value;

    public Vertex(T value)
    {
        this.value = value;
    }

    @Override
    public int compareTo(Vertex<T> o)
    {
        throw new UnsupportedOperationException("Vertex does not implement compareTo()");
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(value, vertex.value);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(value);
    }
}
package ArrayList;

public interface Simple<E> extends Iterable<E>{
    boolean add(E e);
    void delete(int index);
    int size();
    void update(int index, E e);
}

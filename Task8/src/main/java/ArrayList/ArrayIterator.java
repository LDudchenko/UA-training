package ArrayList;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator {
    private int index = 0;
    E[] values;

    ArrayIterator(E[] values){
        this.values = values;
    }


    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public Object next() {
        return values[index++];
    }
}

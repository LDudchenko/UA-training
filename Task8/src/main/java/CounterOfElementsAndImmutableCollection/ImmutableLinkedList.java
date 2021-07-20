package CounterOfElementsAndImmutableCollection;

import java.util.AbstractList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ImmutableLinkedList<T> extends AbstractList {
    private Node start;
    private Node end;

    public ImmutableLinkedList(int length){
        start = new Node();
        end = start;
        for(int i=0; i<length; i++){
            end.next = new Node();
            end.next.previous = end;
            end = end.next;
        }
    }

    public ImmutableLinkedList(T[] arr){
        start = new Node(arr[0]);
        end = start;
        for(int i=1; i<arr.length; i++){
            end.next = new Node(arr[i]);
            end.next.previous = end;
            end = end.next;
        }
    }

    @Override
    public int size() {
        Node element = start;
        int size =0;
        while(element!=null){
            element = element.next;
            size++;
        }
        return size;
    }

    @Override
    public void add(int index, Object data) {
        if(index<0||index>this.size()-1){
            System.out.println("Неверный индекс!");
            return;
        }

        if(index == 0){
            Node t = start;
            start = new Node(data);
            start.next = t;
            return;
        }

        Node element = start;
        int i = 0;
        while(i!=index-1){
            element = element.next;
            i++;
        }
        Node temp = element.next;
        element.next = new Node(data);
        element.next.previous = element;
        element.next.next = temp;
        element.next.next.previous = element.next;
    }

    public void addEnd(int data){
        end.next = new Node(data);
        end.next.previous =end;
        end = end.next;
    }

    public void addStart(int data){
        Node element = new Node(data);
        element.next = start;
        start.previous = element;
        start = element;
    }

    @Override
    public int indexOf(Object o) {
        Node element = start;
        int count=0;
        while(element!=null){
            if(element.data==o){
                return count;
            }
            element=element.next;
            count++;
        }
        return -1;
    }

    @Override
    public Object get(int index) {
        Node element = start;
        int i = 0;
        while(i!=index){
            element = element.next;
            i++;
        }
        return element;
    }

    @Override
    public boolean isEmpty() {
        return start==null;
    }

    @Override
    public boolean contains(Object o) {
        Node element = start;
        while(element!=null){
            if(element.data==o){
                return true;
            }
            element=element.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        Node element = start;
        while(element!=null){
            info.append(element.data+" ");
            element = element.next;
        }
        System.out.println();
        return info.toString();
    }

    @Override
    public Object remove(int index) {
        throw new UnsupportedOperationException("It is immutable linked list!");
    }

    @Override
    public Object set(int index, Object element) {
        throw new UnsupportedOperationException("It is immutable linked list!");
    }


    @Override
    public void clear() {
        throw new UnsupportedOperationException("It is immutable linked list!");
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("It is immutable linked list!");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("It is immutable linked list!");
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("It is immutable linked list!");
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("It is immutable linked list!");
    }

    @Override
    public void replaceAll(UnaryOperator operator) {
        throw new UnsupportedOperationException("It is immutable linked list!");
    }

    @Override
    public boolean removeIf(Predicate filter) {
        throw new UnsupportedOperationException("It is immutable linked list!");
    }
}

class Node<T>{
    T data;
    Node next;
    Node previous;

    public Node(){
        data = null;
        next = null;
        previous = null;
    }

    public Node(T data){
        this.data = data;
        next = null;
        previous = null;
    }

    @Override
    public String toString() {
        return data+"";
    }
}
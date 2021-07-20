package CounterOfElementsAndImmutableCollection;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*Структура данных для подсчёта количества повторений каждого элемента */
        CounterOfElements counterOfElements = new CounterOfElements();
        Integer[] arr = new Integer[]{1,4,7,2,9,2,7,2,1};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arr));
        counterOfElements.count(arrayList);
        System.out.println(counterOfElements);

        counterOfElements = new CounterOfElements();
        String[] arr2 = new String[]{"a", "abc", "abc", " a", "c"};
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList(arr2));
        counterOfElements.count(arrayList2);
        System.out.println(counterOfElements);

        /*Структура данных для подсчёта количества повторений каждого элемента на основе Java Collections*/
        System.out.println(CounterOfElementsOnBaseOfCollection.count(arr));
        System.out.println(CounterOfElementsOnBaseOfCollection.count(arr2));

        /*Реализация коллекции Linked List, в которую можно добавлять данные и нельзя удалять*/
        ImmutableLinkedList immutableIntegerLinkedList = new ImmutableLinkedList(new Integer[]{1,45,8,9});
        immutableIntegerLinkedList.addStart(2);
        immutableIntegerLinkedList.addEnd(90);
        immutableIntegerLinkedList.add(1,777);

        try {
            immutableIntegerLinkedList.remove(2);
            immutableIntegerLinkedList.set(1, Integer.valueOf(9));
        } catch(UnsupportedOperationException e){
            e.printStackTrace();
        }

        System.out.print(immutableIntegerLinkedList.get(1));
        System.out.println(immutableIntegerLinkedList);

        ImmutableLinkedList immutableCharecterLinkedList = new ImmutableLinkedList(new Character[]{'a','b','c'});
        immutableCharecterLinkedList.addStart('d');
        immutableCharecterLinkedList.addEnd('/');
        immutableCharecterLinkedList.add(1,';');

        try {
            immutableCharecterLinkedList.remove(2);
            immutableCharecterLinkedList.set(1, Character.valueOf('p'));
        } catch(UnsupportedOperationException e){
            e.printStackTrace();
        }

        System.out.print(immutableCharecterLinkedList.get(1));
        System.out.println(immutableCharecterLinkedList);

    }
}

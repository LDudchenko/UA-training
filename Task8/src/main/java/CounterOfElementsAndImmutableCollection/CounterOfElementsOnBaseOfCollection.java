package CounterOfElementsAndImmutableCollection;

import java.util.LinkedHashMap;
import java.util.Map;

public class CounterOfElementsOnBaseOfCollection {
    public static <T> Map<T, Integer> count(T[] arr){
        Map<T, Integer> counter = new LinkedHashMap<>();
        for (T element : arr) {
            int newValue = counter.getOrDefault(element, 0) + 1;
            counter.put(element, newValue);
        }
        return counter;
    }
}

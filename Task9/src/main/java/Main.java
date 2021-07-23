import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,-1,12,8,45,0,9};

        //Найти среднее значение элементов массива
        System.out.println("Average:");

        OptionalDouble average1 = IntStream.of(arr).average();
        OptionalDouble average2 = IntStream.of(arr).mapToDouble(x-> (double) x).map(x->x/arr.length).reduce((curr, next)->next+curr);
        double average3 = IntStream.of(arr).mapToDouble(x-> (double) x).map(x->x/arr.length).sum();
        IntSummaryStatistics average4 = IntStream.of(arr).summaryStatistics();

        average1.ifPresent(System.out::println);
        average2.ifPresent(System.out::println);
        System.out.println(average3);
        System.out.println(average4.getAverage());
        System.out.println();

        //Найти минимальный элемент, значение и индекс
        System.out.println("Minimum: ");

        Optional min1 = IntStream.of(arr).boxed().min(Integer::compare);
        IntSummaryStatistics min2 = IntStream.of(arr).summaryStatistics();
        Optional min3 = IntStream.of(arr).boxed().collect(Collectors.minBy(Integer::compare));

        min1.ifPresent(System.out::println);
        System.out.println(min2.getMin());
        min3.ifPresent(System.out::println);
        System.out.println();

        //Посчитать количество элементов равных нулю
        System.out.println("The quantity of elements which equals to zero:");
        long countOfZeroElements = IntStream.of(arr).filter(x -> x==0).count();
        System.out.println(countOfZeroElements);
        System.out.println();

        //Посчитать количество элементов больше нуля
        System.out.println("The quantity of elements which more than zero:");

        long countOfElemntsWhichMoreThanZero1 = IntStream.of(arr).filter(x->x>0).count();
        long countOfElemntsWhichMoreThanZero2 = IntStream.of(arr).sorted().dropWhile(x->x<=0).count();

        System.out.println(countOfElemntsWhichMoreThanZero1);
        System.out.println(countOfElemntsWhichMoreThanZero2);
        System.out.println();

        //Помножить элементы массива на число
        System.out.println("The elements of array multiplied by number:");
        int[] arrOfElements = IntStream.of(arr).map(x->x*5).toArray();
        List<Integer> list = IntStream.of(arr).flatMap(x-> IntStream.of(x*5)).boxed().collect(Collectors.toList());

        System.out.println(Arrays.toString(arrOfElements));
        System.out.println(list);
        System.out.println();
    }
}

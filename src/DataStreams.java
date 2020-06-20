import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataStreams {
    public static void main(String[] args) {
        List<String> stringArrayList = Arrays.asList("234", "324", "56", "4232424", "2733");

        for(String item:stringArrayList) {
            System.out.println(item);
        }

        Stream<String> stream = stringArrayList.stream();
        stream.forEach(a -> System.out.println(a));

        System.out.println("=====================");

        stringArrayList.stream().forEach(a -> System.out.println(a));

        System.out.println("=====================");

//        stream.forEach(a -> System.out.println(a));
        Stream<String> secondStream = stringArrayList.stream();
        secondStream.map(a -> {
            System.out.println(9);
            return a.length();
        }).map(a -> a).forEach(System.out::println);

        System.out.println("=====================");

        ArrayList<Integer> integerList = new ArrayList<>();
        for(int i=0;i<1000;i++) {
            integerList.add(i);
        }

        integerList.stream().filter(a -> a%100 == 0).map(a -> {
            System.out.println("Value");
            return a/100;
        }).filter(a -> a%2 == 0).map(a -> {
            System.out.println("Value2");
            return a;
        }).forEach(System.out::println);

        System.out.println("=====================");

        Optional<Integer> result = integerList.stream().map(a -> a*366786783%25).min(Comparator.comparing(a -> a));
        System.out.println(result.orElse(0));

        result = integerList.stream().map(a -> a*366786783%25).max(Comparator.comparing(a -> a));
        System.out.println(result.orElse(0));

        List<Integer> list = integerList.stream().map(a -> a*366786783%25).collect(Collectors.toList());
        Map<Integer, List<Integer>> map = integerList.stream().map(a -> a*366786783%25).collect(Collectors.groupingBy(a -> a%3));

        List<String> secondStringArrayList = Arrays.asList("234,23423", "324,324", "56,234", "3724", "273,3,1232");
        secondStringArrayList.stream().flatMap(a -> Arrays.stream(a.split(",")).map(b -> Integer.parseInt(b))).forEach(System.out::println);

        Integer[] integerArray = {0,1,2,3,4,5,6,7,8,9};
        Arrays.stream(integerArray).parallel().map(a -> a*2).forEach(System.out::println);

        Integer sumOfElements = Arrays.stream(integerArray).parallel().reduce((a,b) -> a+b).orElse(0);

        return;
    }
}

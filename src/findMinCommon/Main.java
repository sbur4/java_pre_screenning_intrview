package findMinCommon;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> a = Stream.of(11, 200, -3, 5).collect(Collectors.toList());
        List<Integer> b = Stream.of(100, 20, -3, 15).collect(Collectors.toList());
        List<Integer> c = Stream.of(111, 200, -3, 5).collect(Collectors.toList());

        // v1
        List<Integer> combined = Stream.of(a, b, c)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        Optional<Integer> minCommon = combined.stream().min(Integer::compare);
        minCommon.ifPresent(System.out::println);

        // v2
        Set<Integer> setA = new HashSet<>(a);
        Set<Integer> setB = new HashSet<>(b);
        Set<Integer> setC = new HashSet<>(c);

        setA.retainAll(setB);
        setA.retainAll(setC);

        Optional<Integer> minCommon2 = setA.stream().min(Integer::compare);
        minCommon2.ifPresent(System.out::println);
    }
}
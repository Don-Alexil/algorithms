package ro.alexil.algorithms.utils;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Print {

    public static String arrayToString(int[] array) {
        return Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public static String repeat(String s, int length) {
        return IntStream.range(0, length)
                .mapToObj(i -> s)
                .collect(Collectors.joining());
    }
}

package playground.basics;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static java.util.Arrays.binarySearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArraySearchTest {

    static boolean contains(Integer[] ints, int k) {
        return (binarySearch(ints, k)) >= 0;
    }


    @Test
    public void quickSearch() {
        Integer[] ints = {1, 2, 3, 4, 5, 6};
        int k = 5;
        assertTrue(contains(ints, k));

        //lets play with stream
        var integerStream = Arrays.stream(ints);
        var integers = integerStream.iterator();
        while (integers.hasNext()) {
            Integer current = integers.next();
            System.out.print(current + " ");
        }
        System.out.println();
    }
}
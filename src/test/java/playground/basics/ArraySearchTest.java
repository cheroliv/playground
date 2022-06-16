package playground.basics;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArraySearchTest {

    static boolean contains(Integer[] ints, int k) {
        return (Arrays.binarySearch(ints, k)) >= 0;
    }


    @Test
    public void quickSearch() {
        Integer[] ints = {1, 2, 3, 4, 5, 6};
        int k = 5;
        assertTrue(contains(ints, k));

        //lets play with stream
        Stream<Integer> integerStream = Arrays.stream(ints);
        Iterator<Integer> integers = integerStream.iterator();
        while (integers.hasNext()) {
            Integer current = integers.next();
            System.out.print(current + " ");
        }
        System.out.println();
    }
}

package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.GenericSort;
import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import org.ini4j.Ini;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Interface to define the behavior of a Benchmark.
 *
 * @param <T> the underlying type which is passed into (or supplied) to the run/runFromSupplier methods.
 */
public interface Benchmark<T> {
    /**
     * Run function f m times and return the average time in milliseconds.
     *
     * @param t the value that will in turn be passed to function f.
     * @param m the number of times the function f will be called.
     * @return the average number of milliseconds taken for each run of function f.
     */
    default double run(T t, int m) {
        return runFromSupplier(() -> t, m);
    }

    /**
     * Run function f m times and return the average time in milliseconds.
     *
     * @param supplier a Supplier of a T
     * @param m        the number of times the function f will be called.
     * @return the average number of milliseconds taken for each run of function f.
     */
    double runFromSupplier(Supplier<T> supplier, int m);
    public static void main(String[] args) {

        double result = 0;
        for (int i =100; i <= 3200; i=i*2) {
            Random random = new Random();
            List<Integer> random_list = new ArrayList<Integer>();
            for (int j = 0; j < i; j++) {
                random_list.add(random.nextInt(i));
            }
            InsertionSort insertionSort = new InsertionSort(new Config(new Ini()));
            Benchmark<Integer> benchmark = new Benchmark_Timer<>("",
                    blank -> {
                        insertionSort.sort(random_list);
                    });
            result = benchmark.run(0, 10);
            System.out.println("Random Array: Insertion sort with "+i+" elements takes "+result+" ms");
        }
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i =100; i <= 3200; i=i*2) {
            Random random = new Random();
            List<Integer> ordered_list = new ArrayList<Integer>();
            for (int j = 0; j < i; j++) {
                ordered_list.add(i);
            }
            InsertionSort insertionSort = new InsertionSort(new Config(new Ini()));
            Benchmark<Integer> benchmark = new Benchmark_Timer<>("",
                    blank -> {
                        insertionSort.sort(ordered_list);
                    });
            result = benchmark.run(0, 10);
            System.out.println("Ordered Array: Insertion sort with "+i+" elements takes "+result+" ms");
        }
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i =100; i <= 3200; i=i*2) {
            Random random = new Random();
            List<Integer> partiallyOrdered_list = new ArrayList<Integer>();
            for (int j = 0; j < i; j++) {
                if (random.nextInt(50) < 30) {
                    partiallyOrdered_list.add(j);
                } else {
                    partiallyOrdered_list.add((random.nextInt(i)));
                }
            }
            InsertionSort insertionSort = new InsertionSort(new Config(new Ini()));
            Benchmark<Integer> benchmark = new Benchmark_Timer<>("",
                    blank -> {
                        insertionSort.sort(partiallyOrdered_list);
                    });
            result = benchmark.run(0, 10);
            System.out.println("Partially Ordered Array: Insertion sort with "+i+" elements takes "+result+" ms");
        }
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i =100; i <= 3200; i=i*2) {
            Random random = new Random();
            List<Integer> reverseOrdered_list = new ArrayList<Integer>();
            for (int j = 0; j < i; j++) {
                reverseOrdered_list.add(i - j);
            }
            InsertionSort insertionSort = new InsertionSort(new Config(new Ini()));
            Benchmark<Integer> benchmark = new Benchmark_Timer<>("",
                    blank -> {
                        insertionSort.sort(reverseOrdered_list);
                    });
            result = benchmark.run(0, 10);
            System.out.println("Reverse Ordered Array: Insertion sort with "+i+" elements takes "+result+" ms");
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }
}

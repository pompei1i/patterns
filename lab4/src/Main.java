import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        task1FilterOdd(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        task2Average(Arrays.asList(1.5, 2.5, 3.0, 4.0, 5.5));
        task3SortAlphabetically(Arrays.asList("banana", "apple", "cherry", "date", "elderberry"));
        task4SumEven(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        task5Factorial(7);
        task6ProductAndSum(Arrays.asList(1, 2, 3, 4, 5));
        task7Squares(Arrays.asList(1, 2, 3, 4, 5, 6));
        task8SortByLength(Arrays.asList("banana", "kiwi", "apple", "fig", "elderberry", "pear"));
        task9WordCount("The quick brown fox jumps over the lazy dog");
        task10FirstNonEmpty(Arrays.asList("", "", "hello", "world", ""));
        task11AllStartWithUppercase(Arrays.asList("Hello", "World", "Java", "Lambda"));
        task12SecondLargest(Arrays.asList(5, 1, 9, 3, 7, 9, 2));
        task13LargestEven(Arrays.asList(3, 8, 1, 14, 7, 6, 11, 4));
    }

    // 1. Filter odd numbers
    static void task1FilterOdd(List<Integer> numbers) {
        System.out.println("=== 1. Filter odd numbers ===");
        List<Integer> odds = numbers.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
        System.out.println("Input:  " + numbers);
        System.out.println("Odds:   " + odds);
        System.out.println();
    }

    // 2. Average of doubles
    static void task2Average(List<Double> numbers) {
        System.out.println("=== 2. Average of doubles ===");
        OptionalDouble avg = numbers.stream()
                .mapToDouble(Double::doubleValue)
                .average();
        System.out.println("Input:   " + numbers);
        System.out.println("Average: " + avg.orElse(0.0));
        System.out.println();
    }

    // 3. Sort strings alphabetically
    static void task3SortAlphabetically(List<String> strings) {
        System.out.println("=== 3. Sort strings alphabetically ===");
        List<String> sorted = strings.stream()
                .sorted((a, b) -> a.compareTo(b))
                .collect(Collectors.toList());
        System.out.println("Input:  " + strings);
        System.out.println("Sorted: " + sorted);
        System.out.println();
    }

    // 4. Sum of even numbers
    static void task4SumEven(List<Integer> numbers) {
        System.out.println("=== 4. Sum of even numbers ===");
        int sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Input: " + numbers);
        System.out.println("Sum of evens: " + sum);
        System.out.println();
    }

    // 5. Factorial
    static void task5Factorial(int n) {
        System.out.println("=== 5. Factorial ===");
        long factorial = LongStream.rangeClosed(1, n)
                .reduce(1L, (a, b) -> a * b);
        System.out.println(n + "! = " + factorial);
        System.out.println();
    }

    // 6. Product and sum of all elements
    static void task6ProductAndSum(List<Integer> numbers) {
        System.out.println("=== 6. Product and sum of all elements ===");
        long product = numbers.stream()
                .mapToLong(Integer::longValue)
                .reduce(1L, (a, b) -> a * b);
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Input:   " + numbers);
        System.out.println("Product: " + product);
        System.out.println("Sum:     " + sum);
        System.out.println();
    }

    // 7. Square of each number
    static void task7Squares(List<Integer> numbers) {
        System.out.println("=== 7. Squares of each number ===");
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Input:   " + numbers);
        System.out.println("Squares: " + squares);
        System.out.println();
    }

    // 8. Sort strings by length ascending
    static void task8SortByLength(List<String> strings) {
        System.out.println("=== 8. Sort strings by length (ascending) ===");
        List<String> sorted = strings.stream()
                .sorted((a, b) -> a.length() - b.length())
                .collect(Collectors.toList());
        System.out.println("Input:  " + strings);
        System.out.println("Sorted: " + sorted);
        System.out.println();
    }

    // 9. Count words in a sentence
    static void task9WordCount(String sentence) {
        System.out.println("=== 9. Word count in a sentence ===");
        long count = Arrays.stream(sentence.split(" "))
                .filter(w -> !w.isEmpty())
                .count();
        System.out.println("Sentence:   \"" + sentence + "\"");
        System.out.println("Word count: " + count);
        System.out.println();
    }

    // 10. First non-empty string
    static void task10FirstNonEmpty(List<String> strings) {
        System.out.println("=== 10. First non-empty string ===");
        Optional<String> first = strings.stream()
                .filter(s -> !s.isEmpty())
                .findFirst();
        System.out.println("Input: " + strings);
        System.out.println("First non-empty: " + first.orElse("(none)"));
        System.out.println();
    }

    // 11. All strings start with uppercase
    static void task11AllStartWithUppercase(List<String> strings) {
        System.out.println("=== 11. All strings start with uppercase ===");
        boolean allUppercase = strings.stream()
                .allMatch(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)));
        System.out.println("Input:  " + strings);
        System.out.println("All start with uppercase: " + allUppercase);
        System.out.println();
    }

    // 12. Second largest number
    static void task12SecondLargest(List<Integer> numbers) {
        System.out.println("=== 12. Second largest number ===");
        Optional<Integer> second = numbers.stream()
                .distinct()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst();
        System.out.println("Input:          " + numbers);
        System.out.println("Second largest: " + second.orElse(null));
        System.out.println();
    }

    // 13. Largest even number
    static void task13LargestEven(List<Integer> numbers) {
        System.out.println("=== 13. Largest even number ===");
        Optional<Integer> largest = numbers.stream()
                .filter(n -> n % 2 == 0)
                .max(Integer::compareTo);
        System.out.println("Input:        " + numbers);
        System.out.println("Largest even: " + largest.orElse(null));
        System.out.println();
    }
}

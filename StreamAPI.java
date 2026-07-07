import java.util.*;
public class StreamAPI {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Use Stream API to filter even numbers and print them
       int res= nums.stream()
                .filter(n -> n % 2 == 0)
               .map(n-> n * n)
               .reduce(0,(c,e)->c+e);
                System.out.println(res);
    }
}

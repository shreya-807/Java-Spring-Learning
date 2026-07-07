import java.util.*;

public class ParallelStream {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>(10_000);
        Random ran = new Random();
        for (int i = 0; i < 10_000; i++)
            nums.add(ran.nextInt(100));

        long start1 = System.currentTimeMillis();
        int sum1 = nums.stream()
            .map(n -> n * 2)
            .reduce(0, (c, e) -> c + e);
        System.out.println(sum1);
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        int sum2 = nums.stream()
            .mapToInt(n -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return n * 2;
            })
            .sum();
        System.out.println(sum2);
        long end2 = System.currentTimeMillis();

        long start3 = System.currentTimeMillis();
        int sum3 = nums.parallelStream()
            .mapToInt(n -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return n * 2;
            })
            .sum();
        System.out.println(sum3);
        long end3 = System.currentTimeMillis();

        System.out.println("Time taken by stream: " + (end1 - start1));
        System.out.println("Time taken by stream2: " + (end2 - start2));
        System.out.println("Time taken by parallel stream: " + (end3 - start3));
    }
}

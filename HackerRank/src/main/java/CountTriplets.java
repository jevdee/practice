import java.util.*;

public class CountTriplets {
    public static void main(String[] args) {
        new CountTriplets().run();
    }

    public void run() {
//        6 3
//        1 3 9 9 27 81
//        5 5
//        1 5 5 25 125


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long r = sc.nextLong();
        sc.nextLine();

        Map<Long, Long> potential = new HashMap<>();
        Map<Long, Long> counter = new HashMap<>();
        long count = 0;
        for (int i = 0; i < n; i++) {
            long num = sc.nextLong();
            long key = num / r;

            if (counter.containsKey(key) && num % r == 0) {       //방금 들어온 숫자의 바로앞 트리플렛 있냐??
                count += counter.get(key);
            }

            if (potential.containsKey(key) && num % r == 0) {
                long c = potential.get(key);
                counter.put(num, counter.getOrDefault(num, 0L) + c);
            }

            potential.put(num, potential.getOrDefault(num, 0L) + 1);
        }


        System.out.println(count);
        // 2325652489

    }
}

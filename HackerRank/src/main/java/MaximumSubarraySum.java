import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class MaximumSubarraySum {
    public static void main(String[] args) throws IOException {
//        1
//        5 7
//        3 3 9 9 5
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = 0;
        while(x++ < n) {
            String[] s = br.readLine().split(" ");
            int length = Integer.parseInt(s[0]);        //최대 100000
            long m = Long.parseLong(s[1]);
            long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            TreeSet<Long> set = new TreeSet<>();

            long max = -1;
            long curr = 0;
            for (int i = 0; i < input.length; i++) {
                curr = (curr + input[i]) % m;
                max = Math.max(curr, max);

                Long high = set.higher(curr);
                if(high != null) {
                    max = Math.max((curr-high+m) % m, max);
                }

                set.add(curr);
            }

            System.out.println(max);

        }

    }
}

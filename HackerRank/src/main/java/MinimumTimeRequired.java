import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinimumTimeRequired {
    public static void main(String[] args) throws IOException {
//        3 10
//        1 3 4
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int goal = Integer.parseInt(s[1]);
        long[] machines = Arrays.stream(br.readLine().split(" ")).mapToLong(a -> Long.parseLong(a)).toArray();
        Arrays.sort(machines);

        long result = 0;
        long min = 1;
        long max = machines[0] * goal;

        while(min < max) {
            long mid = (min + max) / 2;
            long product = 0;
            for (long i : machines) {
                product += (mid / i);
            }

            if(product < goal)
                min = mid+1;
            else {
                result = mid;
                max = mid;
            }
        }

        System.out.println(result);

    }
}

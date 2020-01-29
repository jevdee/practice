import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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

            long[] arr = new long[length];
            arr[length-1] = input[length-1] % m;
            long max = -1;

            int i=length-1;
            while(i > -1) {
                if(max == m-1)
                    break;

                int j = i;
                while(j < length) {
                    arr[j] = (arr[j] + input[i]) % m;
                    if(arr[j] > max) {
                        max = arr[j];
                    }
                    j++;
                }
                i--;
            }

            System.out.println(max);

        }

    }
}

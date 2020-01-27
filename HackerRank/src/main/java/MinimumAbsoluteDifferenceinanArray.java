import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinimumAbsoluteDifferenceinanArray {
    public static void main(String[] args) throws IOException {

//        10
//        -59 -36 -13 1 -53 -92 -2 -96 -54 75
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long min = Long.MAX_VALUE;
        Arrays.sort(arr);

        for (int i = 0; i < n-1; i++) {
            long tmp = getAbsoluteDifference(arr[i], arr[i+1]);
            if(tmp < min) {
                min = tmp;
            }
        }

        System.out.println(min);
    }

    public static long getAbsoluteDifference(int a, int b) {
        return Math.abs(a - b);
    }
}

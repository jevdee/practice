import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxMin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n-k+1; i++) {
            int value = Math.abs(arr[i] - arr[i+k-1]);
            if(min > value) {
                min = value;
            }
        }

        System.out.println(min);
    }
}

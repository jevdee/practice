import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(maxSubsetSum(arr));
    }

    static int maxSubsetSum(int[] arr) {
        if(arr.length < 3) {
            return 0;
        }

        int[] maxArr = new int[arr.length];
        maxArr[0] = arr[0];
        maxArr[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int tmp = Math.max(Math.max(maxArr[i-2], arr[i]), maxArr[i-2]+arr[i]);
            maxArr[i] = Math.max(tmp, maxArr[i-1]);
        }

        return maxArr[maxArr.length-1];

    }
}

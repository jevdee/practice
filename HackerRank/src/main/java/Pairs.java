import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pairs {
    public static void main(String[] args) throws IOException {
//        5 2
//        1 5 3 4 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int result = 0;

        for (int i = 0; i < n; i++) {
            int tmp = Arrays.binarySearch(arr, arr[i]+k);

            if(tmp >= 0) {
                result++;
            }
        }

        System.out.println(result);


    }
}

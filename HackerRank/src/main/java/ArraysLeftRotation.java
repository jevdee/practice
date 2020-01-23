import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArraysLeftRotation {
    public static void main(String[] args) throws IOException {
//        5 4
//        1 2 3 4 5
//        5 1 2 3 4
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int d = Integer.parseInt(ss[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[(i-d+n) % n] = arr[i];
        }

        System.out.println(Arrays.toString(res).replaceAll("[^0-9 ]",""));

    }
}

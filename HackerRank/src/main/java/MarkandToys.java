import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MarkandToys {
//    7 50
//    1 12 5 111 200 1000 10
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(a -> Integer.parseInt(a)).toArray();
        Arrays.sort(arr);

        int sum = 0;
        int i = 0;
        while(sum < k && i < n) {
            sum += arr[i];
            i++;
        }
        System.out.println(i-1);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class FraudulentActivityNotifications {
//    9 5
//    2 3 4 2 3 6 8 4 5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        double[] arr = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        int notice = 0;
        for (int i = d; i < n; i++) {
            if(arr[i] >= getMedian(Arrays.copyOfRange(arr, i-d, i)) * 2) {
                notice++;
            }
        }
        System.out.println(notice);
    }

    public static double getMedian(double[] arr) {
        Arrays.sort(arr);
        if(arr.length % 2 == 1) {
            return arr[arr.length / 2];
        } else {
            return((arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0);
        }
    }
}

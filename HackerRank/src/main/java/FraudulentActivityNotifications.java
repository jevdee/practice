import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class FraudulentActivityNotifications {
//    9 5
//    0 1 2 3 4 5 6 7 8
//    2 3 4 2 3 6 8 4 5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);

        // 0 <= arr[i] <= 200
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int notice = 0;
        int[] count = new int[201];
        for (int i = 0; i < d; i++) {
            count[arr[i]]++;
        }

        for (int i = d; i < n; i++) {
            if(arr[i] >= getMedian(arr, count, d) ) {
                notice++;
            }
            count[arr[i-d]]--;
            count[arr[i]]++;
        }
        System.out.println(notice);
    }

    public static int getMedian(int[] arr, int[] count, int d) {
        int[] freq = count.clone();
        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i-1] + freq[i];
        }

        if(d % 2 == 1) {
            int idx = d / 2 + 1;
            int i;
            for (i = 0; i < freq.length; i++) {
                if(freq[i] >= idx) {
                    break;
                }
            }
            return i*2;
        } else {
            int idx = d / 2;
            int i;
            int j = 0;
            boolean find = false;
            for (i = 0; i < freq.length; i++) {
                if(freq[i] >= idx && !find) {
                    find = true;
                    j = i;
                }
                if(freq[i] >= idx+1) {
                    break;
                }
            }
            return i+j;
        }
    }
}

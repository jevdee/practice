import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LuckBalance {
    public static void main(String[] args) throws IOException {
//        6 3
//        5 1
//        2 1
//        1 1
//        8 1
//        10 0
//        5 0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int k = Integer.parseInt(ss[1]);
        List<Integer> list = new ArrayList<>();

        int score = 0;
        for (int i = 0; i < n; i++) {
            ss = br.readLine().split(" ");
            int l = Integer.parseInt(ss[0]);
            int t = Integer.parseInt(ss[1]);

            if(t == 0) {
                score += l;
            } else {
                list.add(l);
            }
        }

        Collections.sort(list, Collections.reverseOrder());
        int a = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if(a < k) {
                score += list.remove(0);
                a++;
            } else {
                score -= list.remove(0);
            }
        }

        System.out.println(score);
    }
}

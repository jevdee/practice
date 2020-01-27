import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class GreedyFlorist {
    public static void main(String[] args) throws IOException {
//        5 3
//        1 3 5 7 9
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);        //number of flowers
        int k = Integer.parseInt(ss[1]);        //number of friends
        int[] costArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(costArr);

        int[] bought = new int[k];
        int totalCost = 0;
        int friendNo = 0;
        for (int i = n-1; i >= 0; i--) {
            totalCost += costArr[i] * (bought[friendNo] + 1);
            bought[friendNo]++;
            friendNo = (friendNo + 1) % k;
        }

        System.out.println(totalCost);




    }
}

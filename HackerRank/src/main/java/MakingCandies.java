import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakingCandies {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long m = Long.parseLong(s[0]);
        long w = Long.parseLong(s[1]);
        long p = Long.parseLong(s[2]);
        long n = Long.parseLong(s[3]);
        // 5 2 10302 9133131738
        // 3584

        long day = 1;
        double candies = 0;

        while(true) {
            double production = m * w;
            candies += production;

            if(candies >= n) {
                System.out.println(day);
                break;
            }
            if(candies+production >= n) {
                System.out.println(day+1);
                break;
            }


            if(candies < p && production < p) {
                long skip = (long) Math.ceil(p / production);
                day = day + skip - 1;
                candies = candies + (skip-1) * production;
            }

            double canPurchase = Math.floor(candies / p);
            double i = canPurchase;
            if(i > 0) {
                while(i > 0) {
                    if(m > w) {
                        w++;
                    } else {
                        m++;
                    }
                    i--;
                }

                candies = candies - p * canPurchase;
            }
            day++;
        }

    }
}

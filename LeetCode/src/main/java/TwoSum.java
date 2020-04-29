import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TwoSum {
//3
//1
//3
//7
//3
//4
//3
//3
    public static void main(String[] args) {

        new TwoSum().getMaxHeight();


    }

    public int getMaxHeight() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stickPositions = new int[n];
        int[] stickHeight = new int[n];
        for(int i=0; i<n; i++) {
            stickPositions[i] = sc.nextInt();
        }
        sc.nextInt();
        for(int i=0; i<n; i++) {
            stickHeight[i] = sc.nextInt();
        }

        int max = 0;
        for(int i=0; i<n-1; i++) {
            int gap = stickPositions[i+1] - stickPositions[i] - 1;
            if(gap == 0)
                continue;

            int mudHeight = Math.min(stickHeight[i], stickHeight[i+1]);
            System.out.println("mudHeight = "+mudHeight);

            int diff = 1;

            while(diff <= gap) {
                if(stickHeight[i] != stickHeight[i+1]) {
                    System.out.println("diff = "+diff+"    gap = "+gap);
                    System.out.println(Math.ceil((diff+1)/2.0));
                    System.out.println((int) Math.ceil((diff+1)/2.0));
                    System.out.println("@@@"+(mudHeight+(int) Math.ceil((diff+1)/2.0)) );
                    max = Math.max(mudHeight+(int) Math.round(((diff+1)/2.0)), max);
                } else if(stickHeight[i] == stickHeight[i+1]) {
                    System.out.println("diff = "+diff+"    gap = "+gap);
                    System.out.println("@@@"+(mudHeight+(int)((diff+1)/2)));
                    max = Math.max(mudHeight+(int)((diff+1)/2), max);
                }

                diff++;
            }
            System.out.println("max = "+max);
        }
        System.out.println(max);
        return max;

    }


}

import java.util.Scanner;

public class RecursionDavisStaircase {
    private static long[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new long[37];
        arr[1]=1;
        arr[2]=2;
        arr[3]=4;

        for (int i = 0; i < n; i++) {
            int stairs = sc.nextInt();
            System.out.println(getNumberOfWays(stairs));
        }
    }

    public static long getNumberOfWays(int n) {
        if(arr[n] == 0)
            arr[n] = (getNumberOfWays(n-1) + getNumberOfWays(n-2) + getNumberOfWays(n-3)) % 10000000007L;
        return arr[n];
    }
}

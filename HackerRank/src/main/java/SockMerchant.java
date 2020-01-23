import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SockMerchant {
    public SockMerchant(int n, String[] ss) {
        findSocksToSell(n, ss);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        SockMerchant sm = new SockMerchant(n, ss);
//        9
//        10 20 20 10 10 30 50 10 20

    }

    public void findSocksToSell(int n, String[] ss) {
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }

        int num = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int color : arr) {
            if(set.contains(color)) {
                num++;
                set.remove(color);
            } else {
                set.add(color);
            }
        }
        System.out.println(num);
    }
}

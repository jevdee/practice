import java.util.Scanner;

public class MinimumSwaps2 {
    public MinimumSwaps2(int n, String[] ss) {
        run(n, ss);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        MinimumSwaps2 ms = new MinimumSwaps2(n, ss);
//        7
//        7 1 3 2 4 5 6
    }

    public void run(int n, String[] ss) {
        int count = 0;
        for(int i=0; i<n; ) {
            String idx = ""+(i+1);

            if(!ss[i].equals(idx)) {
                int x = Integer.parseInt(ss[i]);
                String tmp = ss[i];
                ss[i] = ss[x-1];
                ss[x-1] = tmp;
                count++;
            } else {
                i++;
            }

        }

        System.out.println(count);
    }
}

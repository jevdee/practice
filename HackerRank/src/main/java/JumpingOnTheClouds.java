import java.util.Scanner;

public class JumpingOnTheClouds {
    public JumpingOnTheClouds(int n, String[] ss) {
        countJumps(n, ss);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        String[] ss = s.split(" ");

        JumpingOnTheClouds j = new JumpingOnTheClouds(n, ss);

//        7
//        0 0 1 0 0 1 0
//        0 0 0 1 0 0
    }

    public void countJumps(int n, String[] ss) {
        int count = 0;
        int i=0;
        while(i < n-1) {
            if(i+2 < n) {
                if (ss[i + 2].equals("0")) {
                    i += 2;
                } else {
                    i++;
                }
            } else {
                if (ss[i + 1].equals("0")) {
                    i++;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}

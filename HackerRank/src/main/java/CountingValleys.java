import java.util.Scanner;

public class CountingValleys {

    public CountingValleys(int n, String s) {
        countVallies(n, s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        CountingValleys cv = new CountingValleys(n, s);

//        8
//        UDDDUDUU
    }

    public void countVallies(int n, String s) {
        int level = 0;
        int count = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c == 'U') {
                level++;
                if(level == 0) {
                    count++;
                }
            } else {
                level--;
            }
        }

        System.out.println(count);
    }



}

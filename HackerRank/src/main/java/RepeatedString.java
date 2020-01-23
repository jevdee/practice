import java.util.Scanner;

public class RepeatedString {

    public RepeatedString(long n, String s) {
        run(n, s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        long n = Long.parseLong(sc.nextLine());

        RepeatedString j = new RepeatedString(n, s);

//        aba
//        10
//        1000000000000
    }

    public void run(long n, String s) {
        int length = s.length();
        long appear = countA(length, s);
        long result = -1;

        long repeat = n / length;

        if(repeat == 0) {
            result = countA(n, s);
        } else {
            long remainLength = n % length;
            result = appear * repeat + countA(remainLength, s);
        }
        System.out.println(result);


    }

    public long countA(long length, String s) {
        long appear = 0;
        for(int i=0; i<length; i++) {
            if(s.charAt(i) == 'a') {
                appear++;
            }
        }

        return appear;
    }
}

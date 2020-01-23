import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulation {
    public static void main(String[] args) {

        ArrayManipulation am = new ArrayManipulation();

//        5 3
//        1 2 100
//        2 5 100
//        3 4 100
    }

    public ArrayManipulation() {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int m = sc.nextInt();


        long[] arr = new long[size+1];
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();

            arr[a-1] += k;
            arr[b] += k * -1;
        }

        long max = 0;
        long sum = 0;
        for(long i : arr) {
            sum += i;
            if(max < sum) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}

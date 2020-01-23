import java.util.Scanner;

public class NewYearChaos {
    public static void main(String[] args) {
//        2
//        5
//        2 1 5 3 4
//        5
//        2 5 1 3 4

        NewYearChaos nyc = new NewYearChaos();
    }

    public NewYearChaos() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++) {
            int m = Integer.parseInt(sc.nextLine());
            String s = sc.nextLine();
            String[] ss = s.split(" ");
            int[] inputArr = toIntArr(ss);
            if(inputArr == null)
                continue;

            int result = 0;
            int idx = m-1;
            for(int j=idx; j>0; j--) {

                if(inputArr[j] < inputArr[j-1]) {
                    int tmp = inputArr[j];
                    inputArr[j] = inputArr[j-1];
                    inputArr[j-1] = tmp;
                    result++;
                }
                if(inputArr[idx] == idx+1) {
                    j = idx--;
                }
                if(j == 1 && idx != 1) {
                    j = idx+1;
                }
            }
//            System.out.println(inputArr.toString());
            System.out.println(result);
        }
    }

    public int[] toIntArr(String[] ss) {
        int size = ss.length;
        int[] intArr = new int[size];
        int[] idxArr = new int[size];


        for(int i=0; i<size; i++) {
            intArr[i] = Integer.parseInt(ss[i]);
            idxArr[i] = intArr[i] - (i+1);
            if(idxArr[i] > 2) {
                System.out.println("Too chaotic");
                return null;
            }
        }



        return intArr;
    }
}

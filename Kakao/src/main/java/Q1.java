import java.util.Scanner;

public class Q1 {
    public static String lpad(String s, int num) {
        for(int i=0; i<num; i++) {
            s = "0" + s;
        }
        return s;
    }

    public static void main(String[] args) {
//        int n = 5;
//        int[] arr1 = {9, 20, 28, 18, 11};
//        int[] arr2 = {30, 1, 21, 17, 28};
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};

        String[] bArr1 = new String[arr1.length];
        String[] bArr2 = new String[arr2.length];
        for(int i=0; i<arr1.length; i++) {
            String tmp1 = Integer.toBinaryString(arr1[i]);
            if(tmp1.length() < n+1) {
                tmp1 = lpad(tmp1, n - tmp1.length());
            }
            bArr1[i] = tmp1;

            String tmp2 = Integer.toBinaryString(arr2[i]);
            if(tmp2.length() < n+1) {
                tmp2 = lpad(tmp2, n - tmp2.length());
            }
            bArr2[i] = tmp2;
        }

        //벽=1 공백=0
        //하나라도 벽이면 벽
        //둘다 공백이면 공백
        String[] arr3 = new String[arr2.length];
        for(int i=0; i<arr1.length; i++) {
            String s = "";
            for(int j=0; j<bArr1[i].length(); j++) {
                int a = Integer.parseInt(bArr1[i].substring(j,j+1));
                int b = Integer.parseInt(bArr2[i].substring(j,j+1));

                if(a == 1 || b == 1) {
                    s += "#";
                } else {
                    s += " ";
                }
            }
            arr3[i] = s;
            System.out.println(arr3[i]);
        }

    }

}

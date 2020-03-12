import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Candies {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n < 2) {
            System.out.println(1);
            return;
        }

        int[] arr = new int[n];
        int[] resArr = new int[n];
        int i=0;
        int j=0;
        for (int k = 0; k < n; k++) {
            arr[k] = Integer.parseInt(br.readLine());
        }

        while(i < n) {
            int start = i;
            Set<Integer> set = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            while(true) {
                set.add(arr[i]);
                list.add(arr[i]);
                if (arr[i] < arr[i + 1]) {
                    i++;
                    break;
                }
                i++;
            }

            int maxNum = set.size();
            if(j != 0 && maxNum < resArr[j-1]) {
                maxNum = resArr[j-1] + 1;
            }

            if(set.size() > 1 && list.size() == set.size()) {   //여러종류의 숫자가 중복없음  4 3 2
                for (int k=0;  k<list.size(); k++) {
                    resArr[j] = maxNum;
                    maxNum--;
                    j++;
                }
            } else if(set.size() == 1 && list.size() > 1) {    //한종류의 숫자가 여러개 중복 2 2 2 2
                resArr[j] = maxNum;
                j++;
                for (int k=1;  k<list.size(); k++) {
                    resArr[j] = 1;
                    j++;
                }
            } else if(set.size() > 1 && list.size() > set.size()) { //여러종류의 숫자가 여러개이면서 중복숫자 포함 3 3 2, 3 2 2, 3 2 2 1 1
                resArr[j] = maxNum;
                j++;
                start++;

                for (int k = 1; k < list.size(); k++,start++) {
                    if(arr[start-1] == arr[start]) {
                        resArr[j] = maxNum;
                    } else {
                        maxNum--;
                        resArr[j] = maxNum;
                    }
                }
            } else {        //한종류의 숫자가 1개
                resArr[j] = maxNum;
                j++;
            }
        }




        System.out.println(Arrays.stream(resArr).sum());

    }


}

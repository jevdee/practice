import java.io.*;
import java.util.Arrays;

public class MergeSortCountingInversions {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new InputStreamReader(MergeSortCountingInversions.class.getResourceAsStream("/mergesort_input.txt")));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            long count = divide(arr, 0, arr.length-1);
            System.out.println(count);
        }
    }

    public static long divide(int arr[], int start, int end) {
        if(start == end)
            return 0;

        long count = 0;
        int mid = (start + end) / 2;
        count += divide(arr, start, mid);
        count += divide(arr, mid+1, end);
        count += merge(arr, start, end);

        return count;
    }

    public static long merge(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        long count = 0;
        int rightIdx = mid+1;
        int leftIdx = start;
        int currIdx = 0;
        int[] copyArr = new int[end-start+1];

        while(leftIdx <= mid && rightIdx <= end) {
            if (arr[leftIdx] > arr[rightIdx]) {
                count += mid - leftIdx + 1;
                copyArr[currIdx] = arr[rightIdx];
                rightIdx++;
            } else {
                copyArr[currIdx] = arr[leftIdx];
                leftIdx++;
            }
            currIdx++;
        }

        while(leftIdx <= mid) {
            copyArr[currIdx] = arr[leftIdx];
            leftIdx++;
            currIdx++;
        }

        while(rightIdx <= end) {
            copyArr[currIdx] = arr[rightIdx];
            rightIdx++;
            currIdx++;
        }

        System.arraycopy(copyArr, 0, arr, start, end-start+1);

        return count;
    }
}




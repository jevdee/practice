
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class LargestRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Object[] tmp =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray();
        Integer[] arr = Arrays.copyOf(tmp, n, Integer[].class);

        Arrays.sort(arr, new MyComparator());

        long max = 0;
        int i=0;
        while(i < n) {
            if(max < (i+1) * arr[i]) {
                max = (i+1) * arr[i];
            }
            i++;
        }
        System.out.println(max);
    }
}

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}

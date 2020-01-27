import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HashTablesIceCreamParlor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int money = Integer.parseInt(br.readLine());
            int sizeOfArr = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int j = 0; j < sizeOfArr; j++) {
                List list = map.getOrDefault(arr[j], new ArrayList<>());
                if(arr[j] < money) {
                    list.add(j);
                    map.put(arr[j], list);
                }

            }

            Iterator<Integer> iter = map.keySet().iterator();
            while(iter.hasNext()) {
                int value = iter.next();
                int remains = money - value;
                List<Integer> remainsList = map.getOrDefault(remains, null);
                if(remainsList != null) {
                    if(remains == value) {
                        Collections.sort(remainsList);
                        System.out.println(remainsList.get(0)+1 + " " + (remainsList.get(1)+1));
                    } else {
                        List<Integer> valueList = map.getOrDefault(value, null);
                        if(valueList.get(0) > remainsList.get(0)) {
                            System.out.println(remainsList.get(0)+1 + " " + (valueList.get(0)+1));
                        } else {
                            System.out.println(valueList.get(0)+1 + " " + (remainsList.get(0)+1));
                        }
                    }
                    break;
                }
            }
        }


    }
}

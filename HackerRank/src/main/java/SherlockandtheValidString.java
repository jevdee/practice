

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SherlockandtheValidString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split("");
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for(String str : s) {
            int value = map.getOrDefault(str, 0);
            int oldFreqVal = freq.getOrDefault(value, 0);
            int newFreqVal = freq.getOrDefault(value+1, 0);

            map.put(str, value+1);
            freq.put(value+1, newFreqVal+1);
            if(oldFreqVal > 1) {
                freq.put(value, oldFreqVal-1);
            } else {
                freq.remove(value);
            }
        }

        if(freq.keySet().size() > 2) {
            System.out.println("NO");
        } else if(freq.keySet().size() <= 1) {
            System.out.println("YES");
        } else {        //size == 2
            Iterator<Map.Entry<Integer, Integer>> iter = freq.entrySet().iterator();
            Map.Entry<Integer, Integer> first = iter.next();
            Map.Entry<Integer, Integer> second = iter.next();
            if((first.getKey() == 1 && first.getValue() == 1) || (second.getKey() == 1 && second.getValue() == 1)) {
                System.out.println("YES");
            } else if (Math.abs(first.getKey() - second.getKey()) == 1) {
                if (first.getValue() == 1 || second.getValue() == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }

    }
}

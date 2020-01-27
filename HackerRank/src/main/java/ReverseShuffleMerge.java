import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class ReverseShuffleMerge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int a = 'a';
        int m = 'z' - a + 1;
        int[] frequency = new int[m];
        s.chars().forEach(c -> frequency[c - a]++);
        int[] count = Arrays.stream(frequency).map(f -> f / 2).toArray();

        int top = -1;
        int[] stack = new int[s.length()];
        for(int n = s.length(); --n >= 0; ) {
            int c = s.charAt(n) - a;
            frequency[c]--;
            if(count[c] < 1) continue;

            count[c]--;
            while(top >= 0 &&
                    stack[top] > c &&
                    frequency[stack[top]] > count[stack[top]]) {
                count[stack[top--]]++; // Increment and then pop the stack
            }
             stack[++top] = c; // Push c on to the stack
        }

        System.out.println(
        IntStream.rangeClosed(0, top)
                .mapToObj(c -> Character.toString((char)(stack[c] + a)))
                .collect(java.util.stream.Collectors.joining("")));


    }
}

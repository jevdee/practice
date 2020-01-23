import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;


public class FrequencyQueries {
// boilerplate 수정한 버전
// Scanner는 timelimit 패스 못함
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        long[][] query = new long[n][2];
        for (int i = 0; i < n; i++) {
            String s = in.readLine();
            String[] ss = s.split(" ");
            query[i][0] = Long.parseLong(ss[0]);
            query[i][1] = Long.parseLong(ss[1]);
        }

        HashMap<Long, Long> map = new HashMap<Long, Long>();
        HashMap<Long, Long> freq = new HashMap<Long, Long>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long[] arr = query[i];
            if(arr[0] == 3) {
                int res = (freq.containsKey(arr[1]) ? 1 : 0);
                ans.add(res);
            } else {
                long oldOccrVal = map.getOrDefault(arr[1], 0L);
                long oldFreqVal = freq.getOrDefault(oldOccrVal, 0L);

                if(arr[0] == 1) {
                    if(oldFreqVal > 1)
                        freq.put(oldOccrVal, oldFreqVal-1);
                    else if(oldFreqVal == 1)
                        freq.remove(oldOccrVal);

                    map.put(arr[1], oldOccrVal+1);
                    long newFreqVal = freq.getOrDefault(oldOccrVal+1, 0L);
                    freq.put(oldOccrVal+1, newFreqVal+1);
                } else {
                    if(oldFreqVal > 1)
                        freq.put(oldOccrVal, oldFreqVal-1);
                    else if(oldFreqVal == 1)
                        freq.remove(oldOccrVal);

                    if(oldOccrVal > 1)
                        map.put(arr[1], oldOccrVal-1);
                    else if(oldOccrVal == 1)
                        map.remove(arr[1]);
                    long newFreqVal = freq.getOrDefault(oldOccrVal-1, 0L);
                    freq.put(oldOccrVal-1, newFreqVal+1);
                }
            }
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
            bufferedWriter.write(
                    ans.stream()
                            .map(Object::toString)
                            .collect(joining("\n"))
                            + "\n");
        }


        in.close();
    }
}
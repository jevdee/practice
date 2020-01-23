import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Q5 {
    public static void main(String[] args) {
//        String str1 = "FRANCE";
//        String str2 = "french";
//        String str1 = "handshake";
//        String str2 = "shake hands";
//        String str1 = "aa1+aa2";
//        String str2 = "AAAA12";
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";

        str1 = StringUtils.lowerCase(str1);
        str2 = StringUtils.lowerCase(str2);

        Q5 q = new Q5(str1, str2);


    }

    public Q5(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();

        for(int i=0; i< str1.length()-1; i++) {
            String s = str1.substring(i, i+2);
            if (StringUtils.isAlpha(s) == true) {
                if(map1.containsKey(s)) {
                    int v = map1.get(s);
                    map1.put(s, ++v);
                } else {
                    map1.put(s, 1);
                }

            }
        }
        for(int i=0; i< str2.length()-1; i++) {
            String s = str2.substring(i,i+2);
            if(StringUtils.isAlpha(s) == true) {
                if(map2.containsKey(s)) {
                    int v = map2.get(s);
                    map2.put(s, ++v);
                } else {
                    map2.put(s, 1);
                }
            }
        }

        int min = getInterValue(map1, map2);
        int max = getUnionValue(map1, map2);


        System.out.println(max);
        System.out.println(min);
        int r = getJ(max, min);
        System.out.println(r);
    }

    // 65536을 곱한 후에 소수점 아래를 버리고 정수부만 출력한다.
    public int getJ(int max, int min) {
        double r = 0.0;
        if(min == 0 && max == 0)
            r = 1;
        else
            r = (double) min / max;
        System.out.println(r);
        r *= 65536;
        System.out.println(r);
        System.out.println((int) r);
        return (int) r;
    }

    public int getUnionValue(Map<String, Integer> map1, Map<String, Integer> map2) {
//        Map<String, Integer> map1 = new HashMap<String, Integer>();
//        map3.putAll(map1);
        Set<String> keys2 = map2.keySet();
        Iterator<String> iter = keys2.iterator();
        while(iter.hasNext()) {
            String s = iter.next();
            if(map1.containsKey(s)) {
                int v1 = map1.get(s);
                int v2 = map2.get(s);
                map1.put(s, Math.max(v1, v2));
            } else {
                map1.put(s, 1);
            }
        }

        int total = 0;
        for(Integer i : map1.values()) {
            total += (int) i;
        }
        return total;
    }

    public int getInterValue(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> map3 = new HashMap<String, Integer>();
//        map3.putAll(map1);
        Set<String> keys2 = map2.keySet();
        Iterator<String> iter = keys2.iterator();
        while(iter.hasNext()) {
            String s = iter.next();
            if(map1.containsKey(s)) {
                int v1 = map1.get(s);
                int v2 = map2.get(s);
                map3.put(s, Math.min(v1, v2));
            } else {
            }
        }

        int total = 0;
        for(Integer i : map3.values()) {
            total += (int) i;
        }
        return total;
    }




}

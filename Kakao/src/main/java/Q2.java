import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q2 {
    public static void main(String[] args) {
//        String input = "1S2D*3T";
//        String input = "1D2S#10S";
        String input = "1T2D3D#";

        String[] arr = new String[3];
        Pattern regex = Pattern.compile("[0-9]+[SDT][*#]?");
        Matcher regexMatcher = regex.matcher(input);

        int idx=0;
        while(regexMatcher.find()) {
            arr[idx] = regexMatcher.group();
            System.out.println(arr[idx]);
            idx++;
        }

        int[] scores = new int[3];
        for(int i=0; i<3; i++) {
            String s = arr[i];
            String[] ss = s.split("S|D|T");
            int score = Integer.parseInt(ss[0]);
            String g = s.substring(ss[0].length(), ss[0].length()+1);

            scores[i] = getScore(score, g);

            if(ss.length == 2) {
                String op = ss[1];

                if (op.equals("*")) {
                    scores[i] = scores[i] * 2;
                    if (i > 0) {
                        for (int j = i - 1; j >= 0; j--) {
                            scores[j] = scores[j] * 2;
                        }
                    }
                } else if (op.equals("#")) {
                    scores[i] = scores[i] * -1;
                }
            }

        }
        int result = 0;
        for(int i=0; i<3; i++) {
            result += scores[i];
        }
        System.out.println(result);



//
//        String[] tokens = new String[9];
//        int idx = 0;
//        for(int i=0; i<ss.length; i++) {
//            if(ss[i].equals("")) {
//                continue;
//            } else {
//                tokens[idx] = ss[i];
//                idx += 3;
//            }
//        }
//
//
//        System.out.println(ss[0]);
//        System.out.println(ss[1]);
//        System.out.println(ss[2]);
//        System.out.println(ss[3]);
////        System.out.println(ss[3]);
////        int len = ss[0].length();
////        String g1 = input.substring(len,len+1);
////        len += ss[1].length()+1;
////        String g2 = input.substring(len,len+1);
////        len += ss[2].length()+1;
////        String g3 = input.substring(len,len+1);
////        System.out.println(g1);
////        System.out.println(g2);
////        System.out.println(g3);
    }

    public static int getScore(int score, String g) {
        int totalScore = 0;
        if(g.equals("D")) {
            totalScore = score * score;
        } else if(g.equals("T")) {
            totalScore = score * score * score;
        } else {
            totalScore = score;
        }
        return totalScore;
    }
}

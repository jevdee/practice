import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//+-++++++++
//+-++++++++
//+-++++++++
//+-----++++
//+-+++-++++
//+-+++-++++
//+++++-++++
//++------++
//+++++-++++
//+++++-++++
//LONDON;DELHI;ICELAND;ANKARA

public class CrosswordPuzzle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 10;
        char[][] arr = new char[n][n];

        int i = 0;
        while(i < n) {
            arr[i] = br.readLine().toCharArray();
            i++;
        }
        String[] inputWords = br.readLine().split(";");

        char[][] res = fillRecursively(arr, inputWords, 0);
        for (int j = 0; j < n; j++) {
            String s = new String(res[j]);
            System.out.println(s);
        }
    }

    public static boolean flag;

    public static char[][] fillRecursively(char[][] arr, String[] inputWords, int ithWord) {
        if(ithWord == inputWords.length) {
            flag = true;
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j] == '+')
                    continue;

                if(canBeFilledToRow(arr, inputWords[ithWord], i, j)) {
                    char[][] newArr = fillToRow(arr, inputWords[ithWord], i, j);
                    char[][] filledArr = fillRecursively(newArr, inputWords, ithWord+1);

                    if(flag) {
                        return filledArr;
                    }
                }

                if(canBeFilledToCol(arr, inputWords[ithWord], i, j)) {
                    char[][] newArr = fillToCol(arr, inputWords[ithWord], i, j);
                    char[][] filledArr = fillRecursively(newArr, inputWords, ithWord+1);

                    if(flag) {
                        return filledArr;
                    }
                }

            }
        }

        return arr;
    }

    public static boolean canBeFilledToRow(char[][] arr, String word, int x, int y) {       //가로
        int n = 0;
        for (int i = y; i < arr.length; i++) {
            if(n == word.length() || (arr[x][i] != '-' && arr[x][i] != word.charAt(n))) {
                break;
            }
            n++;
        }
        return n == word.length();
    }

    public static char[][] fillToRow(char[][] arr, String word, int x, int y) {
        char[][] res = deepCopy(arr);
        for (int i = 0; i < word.length(); i++) {
            res[x][y] = word.charAt(i);
            y++;
        }
        return res;
    }

    public static char[][] deepCopy(char[][] arr) {
        char[][] newArr = new char[arr.length][arr[0].length];
        for (int i = 0; i < newArr.length; i++)
            newArr[i] = Arrays.copyOf(arr[i], arr[i].length);
        return newArr;
    }


    public static boolean canBeFilledToCol(char[][] arr, String word, int x, int y) {
        int n = 0;
        for (int i = x; i < arr.length; i++) {
            if(n == word.length() || (arr[i][y] != '-' && arr[i][y] != word.charAt(n))) {
                break;
            }
            n++;
        }
        return n == word.length();
    }

    public static char[][] fillToCol(char[][] arr, String word, int x, int y) {
        char[][] res = deepCopy(arr);
        for (int i = 0; i < word.length(); i++) {
            res[x][y] = word.charAt(i);
            x++;
        }
        return res;
    }
}
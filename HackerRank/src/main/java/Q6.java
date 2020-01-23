import java.util.ArrayList;
import java.util.List;

public class Q6 {
    private int result = 0;
    public static void main(String[] args) {
//        int n = 6;
//        int m = 6;
//        String[] ss = {"TTTANT","RRFACC","RRRFCC","TRRRAA","TTMMMF","TMMTTJ"};

        int n = 4;
        int m = 5;
        String[] ss = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
//        TTTANT
//        RRFACC
//        RRRFCC
//        TRRRAA
//        TTMMMF
//        TMMTTJ
        Q6 q = new Q6(n,m,ss);


    }

    public Q6(int n, int m, String[] ss) {
        String[][] arr = new String[n][m];
        for(int i=0; i<n; i++) {
            String s = ss[i];
            for(int j=0; j<m; j++) {
                arr[i][j] = s.substring(j, j+1);
            }
        }
        while(run(arr, n, m));

        System.out.println(result);
    }

    public boolean run(String[][] arr, int n, int m) {
        List<Coordinate> list = new ArrayList<Coordinate>();
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<m-1; j++) {
                if(!(arr[i][j] != null && arr[i+1][j] != null && arr[i][j+1] != null && arr[i+1][j+1] != null))
                    continue;
                if((arr[i][j].equals(arr[i][j+1])) && (arr[i][j].equals(arr[i+1][j])) && (arr[i][j].equals(arr[i+1][j+1])) ) {
                    list.add(new Coordinate(i,j));
                    list.add(new Coordinate(i+1,j));
                    list.add(new Coordinate(i,j+1));
                    list.add(new Coordinate(i+1,j+1));
                }
            }
        }

        if(!list.isEmpty()) {
            for (Coordinate c : list) {
                int x = c.getX();
                int y = c.getY();
                if(arr[x][y] != null) {
                    result++;
                    arr[x][y] = null;
                }

            }

            handleNull(arr, n, m);

        } else {
            return false;
        }
        return true;
    }

    public void handleNull(String[][] arr, int n, int m) {
        for(int i=0; i<m; i++) {
            int pos = -1;
            for(int j=n-1; j>-1; j--) {
                if(arr[j][i] == null) {
                    if(pos < 0)
                        pos = j;
                    else
                        continue;
                } else {
                    if(pos < 0) {
                        continue;
                    } else {
                        arr[pos][i] = arr[j][i];
                        arr[j][i] = null;
                        pos = j;
                    }
                }
            }
        }
    }

    public class Coordinate {
        private int x = 0;
        private int y = 0;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}





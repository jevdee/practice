public class Q3 {
    String[] cache;
    int idx;

    public Q3(int cacheSize) {
        cache = new String[cacheSize];
        idx = 0;
    }

    public static void main(String[] args) {
        int cacheSize = 0;
//        String[] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
//        String[] arr = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
//        String[] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
//        String[] arr = {"Jeju", "Pangyo", "NewYork", "newyork"};
        String[] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        Q3 q3 = new Q3(cacheSize);
        q3.run(arr, cacheSize);
    }

    public void run(String[] arr, int cacheSize) {
        for(int i=0; i<arr.length; i++) {
            arr[i] = arr[i].toLowerCase();
        }
        int time = 0;
        for(int i=0; i<arr.length; i++) {
            if(isCacheHit(arr[i])) {
                time++;
            } else {
                time += 5;
                if(cacheSize > 0) {
                    cache[idx] = arr[i];
                    idx = (idx + 1) % cacheSize;
                }
            }

//            System.out.println(time);
        }

        System.out.println(time);
    }

    public boolean isCacheHit(String s) {
        for(int i=0; i<cache.length; i++) {
            if(cache[i] == null) {
                return false;
            }
            if(cache[i].equals(s)) {
                return true;
            }
        }
        return false;
    }
}



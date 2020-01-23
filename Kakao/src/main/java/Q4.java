import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q4 {
    public static void main(String[] args) {
//        int n = 1;      //운행횟수
//        int t = 1;      //운행간격(분)
//        int m = 5;      //가용인원수
//        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};

//        int n = 2;      //운행횟수
//        int t = 10;      //운행간격(분)
//        int m = 2;      //가용인원수
//        String[] timetable = {"09:10", "09:09", "08:00"};

//        int n = 2;      //운행횟수
//        int t = 1;      //운행간격(분)
//        int m = 2;      //가용인원수
//        String[] timetable = {"09:00", "09:00", "09:00", "09:00"};

//        int n = 1;      //운행횟수
//        int t = 1;      //운행간격(분)
//        int m = 1;      //가용인원수
//        String[] timetable = {"23:59"};

        int n = 10;      //운행횟수
        int t = 60;      //운행간격(분)
        int m = 45;      //가용인원수
        String[] timetable = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};

        String ignoreTime = "23:59";
        int busFirstTime = 540; //9시를 분으로 표현
        int result = -1;

        List<String> timeList = new ArrayList(Arrays.asList(timetable));

        for(int i=0; i<timeList.size(); i++) {
            if(timeList.get(i).equals(ignoreTime)) {
                timeList.remove(i);
                i--;
            }
        }
        if(timeList.isEmpty()) {
            result = busFirstTime + (n-1)*t;
            System.out.println(getTime(result));
            return;
        }
        Collections.sort(timeList);

        int waitingCrew = timeList.size();
        int totalAvailableCrew = m*n;
        int availableBus = n;
        int availableCrew = m;

        int firstCrewArrivalTime = getCalculatedMinute(timeList.get(0));
        if(totalAvailableCrew <= waitingCrew) {
            if(firstCrewArrivalTime > busFirstTime) {
                result = busFirstTime + n*t - 1;
            } else {
                result = firstCrewArrivalTime - 1;
            }
            System.out.println("result = "+result);
            System.out.println(getTime(result));
        } else {
            int busArrivalTime = busFirstTime;
            int interval = t;
            while(true) {
                if(result != -1)
                    break;
                if(timeList.isEmpty()) {
                    result = busArrivalTime;
                    break;
                }
                for (int i = 0; i < m; i++) {
                    if(timeList.isEmpty())
                        break;

                    String s = timeList.get(0);
                    int crewArrivalTime = getCalculatedMinute(s);
                    if(availableCrew == 1 && availableBus == 1) {
                        result = crewArrivalTime - 1;
                        break;
                    }

                    if(crewArrivalTime <= busArrivalTime) {
                        timeList.remove(0);
                        availableCrew--;
                        continue;
                    } else {
                        busArrivalTime += interval;
                        break;
                    }
                }
                availableBus--;
                availableCrew = m;

            }
            System.out.println("result = " + result);
            System.out.println(getTime(result));
        }



    }

    public static int getCalculatedMinute(String s) {
        String[] ss = s.split(":");
        int h = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);

        return h*60 + m;
    }

    public static String getTime(int time) {
        int hour = time / 60;
        int minute = time % 60;
        String h = "";
        String m = "";
        if(hour < 10) {
            h = "0" + hour;
        } else {
            h = Integer.toString(hour);
        }
        if(minute < 10) {
            m = "0" + minute;
        } else {
            m = Integer.toString(minute);
        }
        return h+":"+m;
    }
}

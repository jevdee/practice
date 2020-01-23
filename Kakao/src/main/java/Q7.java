import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Q7 {
/*
    응답완료시간 S와 처리시간 T가 공백으로 구분
    서버 타임아웃 3초      처리시간은 0.001 ≦ T ≦ 3.000
    입력: [ "2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s" ]
    출력: 2
    설명: 처리시간은 시작시간과 끝시간을 포함하므로
        첫 번째 로그는 01:00:02.003 ~ 01:00:04.002에서 2초 동안 처리되었으며,
        두 번째 로그는 01:00:05.001 ~ 01:00:07.000에서 2초 동안 처리된다.
        따라서, 첫 번째 로그가 끝나는 시점과 두 번째 로그가 시작하는 시점의 구간인 01:00:04.002 ~ 01:00:05.001 1초 동안 최대 2개가 된다.

 */
    public static void main(String[] args) throws ParseException {
//        String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
//        String[] lines = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
        String[] lines = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
        Q7 q = new Q7(lines);
    }

    public Q7(String[] lines) throws ParseException {
        solution(lines);
    }

    public int solution(String[] lines) throws ParseException {     //초당 최대 처리량 리턴
        int size = lines.length;

//        long[] windowTimes = getTimes(lines[0]);
//        long windowStartTime = windowTimes[0];
//        long windowEndTime = windowStartTime + 1000 - 1;
        long[] lastTimes = getTimes(lines[size-1]);
//        long lastStartTime = lastTimes[0];
        long lastEndTime = lastTimes[1];
//        System.out.println(windowStartTime);
//        System.out.println(windowEndTime);


        int max = 0;
        for (int j = 0; j < size; j++) {
//            if(windowStartTime > lastEndTime) {
//                break;
//            }
            long[] windowTimes = getTimes(lines[j]);
            long windowStartTime = windowTimes[0];
            long windowEndTime = windowStartTime + 1000 - 1;

            int tmpMax = 0;
            for (int i = 0; i < size; i++) {
                long[] tmpTimes = getTimes(lines[i]);
                if ((windowStartTime >= tmpTimes[0] && windowStartTime <= tmpTimes[1])
                    || (windowEndTime >= tmpTimes[0] && windowEndTime <= tmpTimes[1])
                    || (windowStartTime < tmpTimes[0] && windowEndTime > tmpTimes[1])) {
                    tmpMax++;
                }
            }


            if(tmpMax > max)
                max = tmpMax;
        }

        System.out.println(max);
        return max;
    }

    public long[] getTimes(String s) throws ParseException {
        String[] ss = s.split(" ");
        ss[2] = ss[2].replace("s","");
        long T = (long) (Double.parseDouble(ss[2]) * 1000 - 1);
        String endTimeString = ss[0] + " " + ss[1];
//        System.out.println(endTimeString);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date d = null;
        try {
            d = df.parse(endTimeString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // millisecond 단위로 변경 (1546354799000)
        long endTime = d.getTime();
        long startTime = endTime - T;

//        System.out.println(startTime);
//        System.out.println(endTime);

        Date startDate = new Date(startTime);
        String startTimeString = df.format(startDate);
//        System.out.println(startTimeString);
//        System.out.println(endTimeString);

        long[] times = new long[2];
        times[0] = startTime;
        times[1] = endTime;

        return times;
    }
}

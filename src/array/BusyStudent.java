package array;

public class BusyStudent {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int sum = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) sum ++;
        }
        return sum;
    }
}

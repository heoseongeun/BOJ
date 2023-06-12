import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int total = 0, current = 0, idx = 0, cnt = 0;
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        while (cnt < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= current) 
                pq.add(jobs[idx++]);

            if (pq.isEmpty()) current = jobs[idx][0];
            else {
                int[] temp = pq.poll();
                total += temp[1] + current - temp[0];
                current += temp[1];
                cnt++;
            }
        }
        return (int) Math.floor(total / jobs.length);
    }
}
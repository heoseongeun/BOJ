import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0, len = queue1.length;
        long sum1 = 0, sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        while(sum1 != sum2) {
            if(answer >= len * 3) return -1;
            int n = 0;
            if(sum1 > sum2) {
                n = q1.poll();
                sum1 -= n;
                q2.offer(n);
                sum2 += n;
            } else {
                n = q2.poll();
                sum2 -= n;
                q1.offer(n);
                sum1 += n;
            }
            answer++;
        }
        
        return answer;
    }
}
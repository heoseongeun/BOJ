import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) pq.offer(i);
        while(!pq.isEmpty()) {
            if (pq.size() == 1) {
                if (pq.peek() >= K) return answer;
                else return -1;
            }
            if (pq.peek() >= K) return answer;
            else {
                pq.offer(pq.poll() + (pq.poll() * 2));
                answer++;
            }
        }
        return answer;
    }
}
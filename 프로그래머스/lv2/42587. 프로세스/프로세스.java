import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) pq.offer(priorities[i]);
        boolean flag = false;
        int answer = 0;
        while (!flag) { 
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) { 
                    pq.poll(); 
                    answer++; 
                    if (i == location) { 
                        flag = true;
                        break; 
                    }
                }
            }
        }
        return answer;
    }
}
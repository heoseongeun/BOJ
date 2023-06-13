import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
		PriorityQueue<Integer> que = new PriorityQueue<>();
		PriorityQueue<Integer> maxque = new PriorityQueue<>(Collections.reverseOrder());
		int maxcnt = 0, cnt = 0;
        for(int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i], " ");
			String s = st.nextToken();
			switch (s) {
                case "I":
                    String next = st.nextToken();
                    que.add(Integer.parseInt(next));
                    maxque.add(Integer.parseInt(next));
                    break;
                case "D":
                    if (que.size() == 0) break;
                    else if (st.nextToken().equals("1")) que.remove(maxque.poll());	
                    else maxque.remove(que.poll());
                    break;
			}
        }
        if (que.size() - maxcnt == 0) answer[1] = 0;
		else answer[1] = que.poll();
		
		if (maxque.size() - cnt == 0) answer[0] = 0;
		else answer[0] = maxque.poll();
		
        return answer;
    }
}
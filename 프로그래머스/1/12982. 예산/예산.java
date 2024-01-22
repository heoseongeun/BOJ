import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
		for(int index: d) {
			if(budget - index < 0) break;
			budget -= index;
			answer++;
		}
        return answer;
    }
}
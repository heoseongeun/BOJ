import java.util.*;

class Solution {
    private int parent[];
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, new Comparator<int[]>() {	
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] == o2[2]) return o1[1] - o2[1];
				else return o1[2] - o2[2];
			}
		});
        
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i < costs.length; i++) {
			int start = find(costs[i][0]);
			int end = find(costs[i][1]);
			if (start != end) { 
				parent[end] = start; 
				answer += costs[i][2];
			}
		}
        return answer;
    }
    
    private int find(int child) {	
		if (parent[child] == child) return child;
		else return parent[child] = find(parent[child]);
	}
}
import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    public int solution(int[] cards) {
        int answer = 0;
        int n = cards.length;
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            dfs(cards, i, 0);
        }
        if(list.size() == 1) return 0;
        Collections.sort(list, Collections.reverseOrder());
        return list.get(0) * list.get(1);
    }
    
    void dfs(int[] cards, int idx, int cnt) {
        if(visited[idx]) {
            list.add(cnt);
            return;
        }
        visited[idx] = true;
        dfs(cards, cards[idx] - 1, cnt + 1);
    }
}
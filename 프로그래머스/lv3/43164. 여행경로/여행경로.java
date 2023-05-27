import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> arrayList;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        arrayList = new ArrayList<>();
        dfs(tickets, 0, "ICN", "ICN");
        Collections.sort(arrayList);
        return arrayList.get(0).split(" ");
    }
    
    public void dfs(String[][] tickets, int depth, String start, String result) {
        if(depth == tickets.length) {
            arrayList.add(result);
            return;
        }
        for(int i = 0; i < tickets.length; i++) {
            if(tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(tickets, depth + 1, tickets[i][1], result + " " + tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}
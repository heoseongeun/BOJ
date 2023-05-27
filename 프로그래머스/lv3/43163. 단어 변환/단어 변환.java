class Solution {
    static boolean[] visited;
    static int answer = 51;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        if(answer == 51) answer = 0;
        return answer;
    }
    
    public void dfs(String start, String target, String[] words, int depth) {
        if(start.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }
        for(int i = 0; i < words.length; i++) {
            if(visited[i]) continue;
            String s = words[i];
            int cnt = 0;
            for(int j = 0; j < s.length(); j++) {
                if(start.charAt(j) != s.charAt(j)) cnt++;
            }
            if(cnt == 1) {
                visited[i] = true;
                dfs(s, target, words, depth + 1);
                visited[i] = false;
            }
        }
    }
}
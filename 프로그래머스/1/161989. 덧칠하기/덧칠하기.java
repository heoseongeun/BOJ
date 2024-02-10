class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int len = section.length;
        int start = section[0];
        for(int i = 1; i < len; i++) {
            if(section[i] - start < m) continue;
            start = section[i];
            answer++;
        }
        return answer + 1;
    }
}
class Solution {
    public int solution(String s) {
        int answer = 0;
        char c = s.charAt(0);
        int n = 1, m = 0;
        for(int i = 1; i < s.length(); i++) {
            if(n == m) {
                answer++;
                m = 0;
                n = 0;
                c = s.charAt(i);
            }
            if(s.charAt(i) == c) n++;
            else m++;
        }
        return answer + 1;
    }
}
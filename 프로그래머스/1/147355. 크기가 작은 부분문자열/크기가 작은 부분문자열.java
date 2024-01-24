class Solution {
    public int solution(String t, String p) {
        int answer = 0, length = p.length();
        long num = Long.parseLong(p), n = 0;
        for(int i = 0; i <= t.length() - length; i++) {
            n = Long.parseLong(t.substring(i, i + length));
            if(n <= num) answer++;
        }
        return answer;
    }
}
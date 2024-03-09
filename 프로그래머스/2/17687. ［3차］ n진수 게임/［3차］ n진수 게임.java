class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        char[] arr = new char[t * m];
        int idx = 0, num = 0;
        while(idx < t * m) {
            String s = Integer.toString(num, n);
            int i = 0;
            for(; i < s.length(); i++) {
                if(idx + i >= t * m) break;
                arr[idx + i] = s.charAt(i);
            }
            idx += i;
            num++;
        }
        for(int i = p - 1; i < t * m; i += m) answer += arr[i];
        return answer.toUpperCase();
    }
}
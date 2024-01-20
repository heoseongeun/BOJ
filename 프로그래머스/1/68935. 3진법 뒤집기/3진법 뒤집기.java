import java.util.*;

class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        while(n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        String s = sb.toString();
        for(int i = s.length() - 1; i >= 0; i--) {
            answer += (s.charAt(i) - '0') * Math.pow(3, s.length() - 1 - i);
        }
        return answer;
    }
}
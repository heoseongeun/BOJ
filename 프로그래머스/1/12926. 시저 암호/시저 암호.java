import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for(int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(c >= 65 && c <= 90) {
                if(c + n > 90) sb.append((char)(c + n - 26));
                else sb.append((char)(c + n));
            } else if(c >= 97 && c <= 122) {
                if(c + n > 122) sb.append((char)(c + n - 26));
                else sb.append((char)(c + n));
            } else sb.append(c);
        }
        return sb.toString();
    }
}
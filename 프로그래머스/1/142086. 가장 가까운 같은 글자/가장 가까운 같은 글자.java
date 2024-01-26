import java.util.*;

class Solution {
    public int[] solution(String s) {
        int n = s.length();
        int[] answer = new int[n];
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(!set.contains(c)) answer[i] = -1;
            else {
                int index = 0;
                while(true) {
                    index++;
                    if(s.charAt(i - index) == c) {
                        answer[i] = index;
                        break;
                    }
                }
            }
            set.add(c);
        }
        return answer;
    }
}
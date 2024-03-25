import java.util.*;

class Solution {
    static int pos;
    public String solution(String p) {
        if(p.equals("")) return p;
        boolean isBalance = balanceString(p);
        String u = p.substring(0, pos);
        String v = p.substring(pos);
        if(isBalance) return u + solution(v);
        else {
            String answer = "(";
            answer += solution(v);
            answer += ')';
            for(int i = 1; i < u.length() - 1; i++) {
                if(u.charAt(i) == '(') answer += ')';
                else answer += '(';
            }
            return answer;
        }
    }
    
    boolean balanceString(String s) {
        Stack<Character> stack = new Stack<>();
        boolean checkBalance = true;
        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                left++;
                stack.push('(');
            } else {
                right++;
                if(stack.isEmpty()) checkBalance = false;
                else stack.pop();
            }
            if(left == right) {
                pos = i + 1; 
                return checkBalance;
            }
        }
        return checkBalance;
    }
}
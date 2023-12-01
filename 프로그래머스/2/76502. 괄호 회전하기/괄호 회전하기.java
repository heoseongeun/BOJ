import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            if(check(s)) answer++;
            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }
    
    boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') stack.push(c);
            else if(stack.isEmpty()) return false;
            else if(c == ')') {
                if(stack.peek() != '(') return false;
                stack.pop();
            } else if(c == ']') {
                if(stack.peek() != '[') return false;
                else stack.pop();
            } else if(c == '}') {
                if(stack.peek() != '{') return false;
                stack.pop();
            } 
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}
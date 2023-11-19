class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(char ch : s.toCharArray()) {            
            sb.append(flag ? Character.toUpperCase(ch) : Character.toLowerCase(ch));
            flag = (ch == ' ') ? true : false;
        }
        return sb.toString();
    }
}
class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        for(int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if(c == '1') {
                if(mode == 1) mode = 0;
                else mode = 1;
            } else {
                if(mode == 0) {
                    if(i % 2 == 0) answer += c;
                } else {
                    if(i % 2 == 1) answer += c;
                }
            }
        }
        if(answer.equals("")) return "EMPTY";
        return answer;
    }
}
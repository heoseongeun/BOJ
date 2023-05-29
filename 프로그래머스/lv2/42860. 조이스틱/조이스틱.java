class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1;
        for(int i = 0; i < len; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
            if (i < len - 1 && name.charAt(i + 1) == 'A') {
                int A = i + 1;
                while(A < name.length() && name.charAt(A) == 'A') A++;
                move = Math.min(move, i + i + (len - A)); // 오른쪽 -> 왼쪽
                move = Math.min(move, i + (len - A) * 2); // 왼쪽 -> 오른쪽
            }
        }
        return answer + move;
    }
}
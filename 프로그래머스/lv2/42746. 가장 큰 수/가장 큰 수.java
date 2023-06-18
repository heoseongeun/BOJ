import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int n = numbers.length;
        String[] str = new String[n];
        for(int i = 0; i < n; i++) 
            str[i] = Integer.toString(numbers[i]);
        Comparator<String> com = (s1, s2) -> (s2 + s1).compareTo(s1 + s2);
        Arrays.sort(str, com);
        for(String s: str) answer += s;
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}
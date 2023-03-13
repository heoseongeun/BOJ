import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> set = new HashSet<>();
        makeNum(set, numbers.toCharArray(), new boolean[numbers.length()], "");
        int answer = 0;
        for(int num: set) {
            if(isPrime(num)) answer++;
        }
        return answer;
    }
    
    private static void makeNum(Set<Integer> set, char[] numbers, 
                                boolean[] used, String s) {
        for(int i = 0; i < numbers.length; i++) {
            if(!used[i]) {
                s += String.valueOf(numbers[i]);
                used[i] = true;
                makeNum(set, numbers, used, s);
                s = s.substring(0, s.length() - 1);
                used[i] = false;
            } else set.add(Integer.parseInt(s));
        }
    }
    
    private static boolean isPrime(int num) {
        if(num <= 1) return false;
        for(int i = 2; i < num / 2 + 1; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
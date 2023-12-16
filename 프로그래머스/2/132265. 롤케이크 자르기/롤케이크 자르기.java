import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        int[] bro = new int[n];
        int[] sis = new int[n];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(topping[i]);
            bro[i] = set.size();
        }
        set.clear();
        for(int i = n - 1; i >= 0; i--) {
            set.add(topping[i]);
            sis[i] = set.size();
        }
        for(int i = 0; i < n - 1; i++) {
            if(bro[i] == sis[i + 1]) answer++;
        }
        return answer;
    }
}
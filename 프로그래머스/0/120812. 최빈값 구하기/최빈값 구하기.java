import java.util.*;

class Solution {
    public int solution(int[] array) {
        int[] cnt = new int[1000];
        int max = 0, answer = 0;
        for(int i = 0; i < array.length; i++) {
            cnt[array[i]]++;
            if(cnt[array[i]] > max) {
                max = cnt[array[i]];
                answer = array[i];
            }
        }
        Arrays.sort(cnt);
        if(cnt[999] == cnt[998]) return -1;
        return answer;
    }
}
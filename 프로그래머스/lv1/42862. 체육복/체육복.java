import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n + 1];
        for(int i = 0; i < lost.length; i++) arr[lost[i]]--;
        for(int i = 0; i < reserve.length; i++) arr[reserve[i]]++;
        for(int i = 1; i <= n; i++) {
            if(i == n) {
                if(arr[i] >= 0 || arr[i - 1] > 0) answer++;    
            } else {
                if(arr[i] >= 0 || arr[i - 1] > 0) answer++;
                else if(arr[i] < 0 && arr[i + 1] > 0) {
                    arr[i + 1]--;
                    answer++;
                }
            }
        }
        return answer;
    }
}
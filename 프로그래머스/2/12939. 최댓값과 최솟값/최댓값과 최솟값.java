import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] list = s.split(" ");
        int n = list.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(list[i]);
        }
        Arrays.sort(arr);
        answer += arr[0] + " " + arr[n - 1];
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n = progresses.length;
        int day = 0, num = 1;
        while(progresses[0] + day * speeds[0] < 100) day++;
        for(int i = 1; i < n; i++) {
            if(progresses[i] + day * speeds[i] >= 100) {
                num++;
            } else {
                arr.add(num);
                while(progresses[i] + day * speeds[i] < 100) day++;
                num = 1;
            }
        }
        arr.add(num);
        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) answer[i] = arr.get(i);
        return answer;
    }
}
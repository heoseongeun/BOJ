import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = arr[0];
        arrayList.add(n);
        for(int i = 1; i < arr.length; i++) {
            if(n == arr[i]) continue;
            n = arr[i];
            arrayList.add(n);
        }
        int[] answer = new int[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++) answer[i] = arrayList.get(i);
        return answer;
    }
}
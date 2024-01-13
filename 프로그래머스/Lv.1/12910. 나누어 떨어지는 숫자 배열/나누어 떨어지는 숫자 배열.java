import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) list.add(arr[i]);
        }
        if(list.isEmpty()) return new int[]{-1};
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
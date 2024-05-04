import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        Integer[] arr = Arrays.stream(numlist).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1 - n);
                int b = Math.abs(o2 - n);
                if(a == b) return o2 - o1;
                return a - b;
            }
        });
        return Arrays.stream(arr).mapToInt(i -> i).toArray();
    }
}
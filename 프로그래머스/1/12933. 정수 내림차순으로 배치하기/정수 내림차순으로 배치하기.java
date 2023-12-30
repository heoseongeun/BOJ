import java.util.*;

class Solution {
    public long solution(long n) {
        String num = Long.toString(n);
        char[] arr = num.toCharArray();
        Arrays.sort(arr);
        char[] result = new char[arr.length];
        int idx = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            result[idx++] = arr[i];
        }
        return Long.parseLong(new String(result));
    }
}
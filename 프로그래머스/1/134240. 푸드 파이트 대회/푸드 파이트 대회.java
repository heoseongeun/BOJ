import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
            food[i] /= 2;
            for(int j = 0; j < food[i]; j++) sb.append(i);
        }
        return sb.toString() + "0" + sb.reverse().toString();
    }
}
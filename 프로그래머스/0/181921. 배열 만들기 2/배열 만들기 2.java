import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int val;
        for (int i = 1; i <= 63; i++) {
            val = Integer.valueOf(Integer.toBinaryString(i)) * 5;
            if (val >= l && val <= r) list.add(val);
        }
        return list.size() == 0 ? new int[] { -1 } : list.stream().mapToInt(Integer::intValue).toArray();
    }
}
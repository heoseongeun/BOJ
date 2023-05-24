import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int count = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for(int i: nums) set.add(i);
        if(set.size() < count) return set.size();
        return count;
    }
}
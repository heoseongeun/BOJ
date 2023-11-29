import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int num = 0, cnt = 0;
        String s = words[0];
        boolean flag = false;
        Set<String> set = new HashSet<>();
        set.add(s);
        for(int i = 0; i < words.length; i++) {
            num++;
            if(i % n == 0) {
                cnt++;
                num = 0;
            }
            if(i == 0) continue;
            if(s.charAt(s.length() - 1) != words[i].charAt(0) ||
              set.contains(words[i])) {
                flag = true;
                break;
            }
            s = words[i];
            set.add(s);
        }
        if(!flag) return new int[]{0, 0};
        return new int[]{num + 1, cnt};
    }
}
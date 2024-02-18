import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int n = targets.length;
        int[] answer = new int[n];
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                if(map.containsKey(keymap[i].charAt(j))) {
                    if(map.get(keymap[i].charAt(j)) > j + 1)
                        map.put(keymap[i].charAt(j), j + 1);
                } else map.put(keymap[i].charAt(j), j + 1);
            }
        }
        for(int i = 0; i < targets.length; i++) {
            int cnt = 0;
            for(int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                Integer min = map.get(c);
                if(min != null) cnt += min;
                else {
                    cnt = -1;
                    break;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
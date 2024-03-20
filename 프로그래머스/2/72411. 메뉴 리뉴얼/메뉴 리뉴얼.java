import java.util.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<String> list = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        for(int i: course) {
            for(String s: orders) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                dfs(0, "", chars, i);
            }
            if(!map.isEmpty()) {
                List<Integer> count = new ArrayList<>(map.values());
                int max = Collections.max(count);
                if(max > 1) {
                    for(String key: map.keySet()) {
                        if(map.get(key) == max) list.add(key);
                    }
                }
            }
            map.clear();
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++) answer[i] = list.get(i);
        return answer;
    }
    
    void dfs(int depth, String course, char[] chars, int i) {
        if (course.length() == i) {
            if (map.containsKey(course)) map.put(course, map.get(course) + 1);
            else map.put(course, 1);
            return;
        }
        if (depth >= chars.length) return;
        dfs(depth + 1, course + chars[depth], chars, i);
        dfs(depth + 1, course, chars, i);
    }
}
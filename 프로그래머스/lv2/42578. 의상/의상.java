import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, List<String>> map = new HashMap<>();
        for(String[] cloth: clothes) {
            if(map.containsKey(cloth[1])) {
                map.get(cloth[1]).add(cloth[0]);
            } else {
                List<String> list = new ArrayList<>();
                list.add("0");
                list.add(cloth[0]);
                map.put(cloth[1], list);
            }
        }
        for(String key: map.keySet()) answer *= map.get(key).size();
        return answer - 1;
    }
}
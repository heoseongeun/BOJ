import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        for(int i = 0; i < cities.length; i++) {
            String s = cities[i].toLowerCase();
            if(!cache.isEmpty() && cache.contains(s)) {
                answer++;
                cache.remove(cache.indexOf(s));
            } else {
                answer += 5;
                if(cache.size() >= cacheSize) cache.remove(cacheSize - 1);
            }
            cache.add(0, s);
        }
        return answer;
    }
}
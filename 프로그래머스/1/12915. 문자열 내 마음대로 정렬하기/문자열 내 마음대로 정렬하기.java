import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        int len = strings.length;
        List<String> list = new ArrayList<>();
		for(int i = 0; i < len; i++) {
			list.add(strings[i].charAt(n) + strings[i]);
		}
		Collections.sort(list);
		for(int i = 0; i < len; i++) {
			strings[i] = list.get(i).substring(1);
		}
        return strings;
    }
}
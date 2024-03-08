import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, Integer> hashMap = new HashMap<>();
        int count = 1;
        for (int i = 65; i <= 90; i++) {
            hashMap.put(Character.toString((char) i), count++);
        }
        int start = 0;
        while (start < msg.length()) {
            int end = start;
            while (end + 1 <= msg.length() && hashMap.containsKey(msg.substring(start, end + 1))) {
                end++;
            }
            answer.add(hashMap.get(msg.substring(start, end)));
            if (end < msg.length()) {
                hashMap.put(msg.substring(start, end + 1), count++);
            }
            start = end;
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
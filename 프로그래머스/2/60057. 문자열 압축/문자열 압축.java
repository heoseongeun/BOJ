import java.util.*;

class Solution {
    public int solution(String s) {
        if(s.length() <= 3) return s.length();
        int answer = Integer.MAX_VALUE;
        for(int len = 1; len <= s.length() / 2; len++){
            ArrayList<String> list = new ArrayList<>();
            int start = 0;
            boolean stop = false;
            while(!stop) {
                int end = start + len;
                if(end >= s.length()) {
                    end = s.length();
                    stop = true;
                }
                String str = s.substring(start, end);
                list.add(str);
                start += len;
            }
            Queue<String> queue = new LinkedList<>(list);
            String previous = queue.poll();
            String now = null;
            int count = 1;
            int length = 0;
            int numLength = 0;
            while(!queue.isEmpty()) {
                now = queue.poll();
                if(now.equals(previous)) count++;
                else { 
                    numLength = count == 1 ? 0 : String.valueOf(count).length();
                    length += previous.length() + numLength;
                    count = 1;
                }
                previous = now;
            }
            numLength = count == 1 ? 0 : String.valueOf(count).length();
            length += previous.length() + numLength;
            if(answer > length) answer = length;
        }      
        return answer;
    }
}
import java.util.stream.*;
import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int N = skill.length();
        char[] skillArr = skill.toCharArray();
        List<Character> list = IntStream.range(0, N).mapToObj(i -> skillArr[i]).collect(Collectors.toList());
        for(int i = 0; i < skill_trees.length; i++) {
            String s = skill_trees[i];
            int idx = 0;
            boolean flag = false;
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(list.contains(c) && c != skill.charAt(idx)) {
                    flag = true;
                    break;
                } else if(list.contains(c) && c == skill.charAt(idx)) idx++;
            }
            if(!flag) answer++;
        }
        return answer;
    }
}
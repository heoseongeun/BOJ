import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        int[] num = new int[n]; // 신고당한 횟수 저장
        Map<String, Integer> map = new HashMap<>(); // 유저 index
        ArrayList<Integer>[] list = new ArrayList[n]; // 유저가 신고한 id 리스트
        for(int i = 0; i < n; i++) {
            map.put(id_list[i], i); // ex) muzi 0, frodo 1, apeach 2, neo 3
            list[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < report.length; i++) {
            String[] s = report[i].split(" ");
            if(list[map.get(s[0])].contains(map.get(s[1]))) continue;
            num[map.get(s[1])]++; // 신고당한 횟수 갱신
            list[map.get(s[0])].add(map.get(s[1]));
        }
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> a = list[i];
            for(int j = 0; j < a.size(); j++) {
                if(num[a.get(j)] >= k) answer[i]++;
            }
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    // 더 많이 준 사람이 선물 하나 받기
    // 기록이 없거나 횟수가 같으면 선물 지수 큰 사람이 선물 하나 받기
    // 선물 지수 = 준 선물의 수 - 받은 선물의 수
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int[] answer = new int[n];
        int[][] gift = new int[n][n];
        int[] num = new int[n];
        Map<String, Integer> map = new HashMap<>();  // index
        for(int i = 0; i < friends.length; i++) map.put(friends[i], i);
        for(int i = 0; i < gifts.length; i++) {
            String[] arr = gifts[i].split(" ");
            int give = map.get(arr[0]), take = map.get(arr[1]);
            gift[give][take]++;
        }
        for(int i = 0; i < n; i++) { // 선물 지수 계산
            int give = 0, take = 0;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                give += gift[i][j];
                take += gift[j][i];
            }
            num[i] = give - take;
        }
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(gift[i][j] > gift[j][i]) answer[i]++;
                else if(gift[i][j] == gift[j][i]) {
                    if(num[i] > num[j]) answer[i]++;
                    else if(num[j] > num[i]) answer[j]++;
                } else answer[j]++;
            }
        }
        return Arrays.stream(answer).max().getAsInt();
    }
}
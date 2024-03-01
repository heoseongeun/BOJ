class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int success = 0;
        for(int i = 0; i < attacks.length; i++) {
            int time = attacks[i][0];
            int attack = attacks[i][1];
            // 1초씩 체력 회복
            answer += (time - success - 1) * bandage[1];
            // 연속 성공 체력 회복
            answer += (time - success - 1) / bandage[0] * bandage[2];
            success = time;
            if(answer > health) answer = health;
            answer -= attack;
            if(answer <= 0) return -1;
        }
        return answer;
    }
}
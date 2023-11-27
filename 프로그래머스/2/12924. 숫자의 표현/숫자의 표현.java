class Solution {
    public int solution(int n) {
        int answer = 0, num = 0;
        for(int i = n - 1; i > 0; i--) {
            num += i;
            for(int j = i - 1; j > 0; j--) {
                num += j;
                if(num == n) {
                    answer++;
                    num = 0;
                    break;
                } else if(num > n) {
                    num = 0;
                    break;
                }
            }
            num = 0;
        }
        return answer + 1;
    }
}
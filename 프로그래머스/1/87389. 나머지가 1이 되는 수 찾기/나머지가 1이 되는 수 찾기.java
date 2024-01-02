class Solution {
    public int solution(int n) {
        int num = 2;
        while(true) {
            if(n % num == 1) break;
            num++;
        }
        return num;
    }
}
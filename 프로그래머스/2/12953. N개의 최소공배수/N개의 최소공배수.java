class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int n = arr.length;
        if(n == 1) return arr[0];
        int g = gcd(arr[0], arr[1]);
        answer = (arr[0] * arr[1]) / g;
        if(n > 2) {
            for(int i = 2; i < n; i++) {
                g = gcd(answer, arr[i]);
                answer = (answer * arr[i]) / g;
            }
        }
        return answer;
    }
    
    int gcd(int a, int b) {
        int r = a % b;
        if(r == 0) return b;
        return gcd(b, r);
    }
}
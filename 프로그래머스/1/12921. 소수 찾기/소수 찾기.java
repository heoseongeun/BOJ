class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 2; i <= n; i++) {
            if(isPrime(i)) answer++;
        }
        return answer;
    }
    
    public boolean isPrime(int n) {
        if(n < 3) return true;
        if(n % 2 == 0) return false;
        for(int i = 3; i <= (int)Math.sqrt(n); i += 2){
            if(n % i == 0) return false;
        }
        return true;
    }
}
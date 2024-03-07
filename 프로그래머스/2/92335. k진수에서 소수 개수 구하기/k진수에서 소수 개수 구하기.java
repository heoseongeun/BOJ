class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = "";
        while(n > 0) {
            s = (n % k) + s;
            n /= k;
        }
        String[] arr = s.split("0");
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals("")) continue;
            long num = Long.parseLong(arr[i]);
            if(isPrime(num)) answer++;
        }
        return answer;
    }
    
    boolean isPrime(long n) {
        if(n == 2 || n == 3) return true;
        if(n < 2 || n % 2 == 0) return false;
        for(int i = 3; i <= Math.sqrt(n); i += 2) {
            if(n % i == 0) return false; 
        }
        return true;
    }
}
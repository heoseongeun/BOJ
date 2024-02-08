class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime(sum)) answer++;
                }
            }
        }
        return answer;
    }
    
    public boolean isPrime(int num) {
        boolean isPrime = true;
        for(int i = 2; i <= (int)Math.sqrt(num); i++) {
            if(num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
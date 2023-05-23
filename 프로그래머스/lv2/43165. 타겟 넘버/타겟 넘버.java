class Solution {
    private static int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }
    
    public void dfs(int[] numbers, int target, int idx, int sum) {
        if(idx == numbers.length) {
            if(sum == target) count++;
        } else {
            dfs(numbers, target, idx + 1, sum + numbers[idx]);
            dfs(numbers, target, idx + 1, sum - numbers[idx]);
        }
    }
}
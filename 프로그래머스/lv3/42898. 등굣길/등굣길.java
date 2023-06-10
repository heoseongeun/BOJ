class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        int[][] arr = new int[n + 1][m + 1];
        for(int[] puddle: puddles) arr[puddle[1]][puddle[0]] = -1;
        arr[1][1] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j<= m; j++){
                if(arr[i][j] == -1){
                    arr[i][j] = 0;
                    continue;
                }
                if(i != 1) arr[i][j] += arr[i - 1][j] % mod;
                if(j != 1) arr[i][j] += arr[i][j - 1] % mod;
            }
        }
        return arr[n][m] % mod;
    }
}
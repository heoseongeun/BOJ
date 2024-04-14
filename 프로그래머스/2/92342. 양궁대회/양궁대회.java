class Solution {
    public static int[] solution(int n, int[] info) {
        final int len = 11;
        int[] answer = {-1};
        int[] ryan = new int[len];
        for(int i = 0 ; i < len ; i++) ryan[i] = info[i] + 1;
        
        int maxDiff = 0;
        int solutionIndex = -1;
        int numOfCases = 2<<len-1;
        for(int i = 0 ; i < numOfCases ; i++){
            int apeachCount = 0;
            int ryanCount = 0;
            int apeachScore = 0;
            int ryanScore = 0;
            
            for(int j = 0 ; j < len-1 ; j++){
                if((i&1<<len-2-j) == 0 && info[j] > 0){
                    apeachScore += 10-j;
                } else if((i&1<<len-2-j) > 0){
                    ryanScore += 10-j;
                    ryanCount += ryan[j];
                }
            }
            if(ryanCount <= n){
                int thisDiff = ryanScore - apeachScore;
                if(thisDiff > maxDiff){
                    maxDiff = thisDiff;
                    solutionIndex = i;
                } else if(maxDiff > 0 && thisDiff == maxDiff){
                    int lastRyanZeroCount = solutionIndex&1;
                    int thisRyanZeroCount = n - ryanCount;
                    if(thisRyanZeroCount > lastRyanZeroCount){
                        solutionIndex = i;
                    } else if(thisRyanZeroCount == lastRyanZeroCount){
                        for(int j = 0 ; j < len-1 ; j++){
                            if ((i&1<<j) > (solutionIndex&1<<j)){
                                solutionIndex = i;
                                break;
                            } else if((i&1<<j) < (solutionIndex&1<<j))
                                break;
                        }
                    }
                }
            } 
        }
        
        if(maxDiff > 0){
            answer = new int[len];
            int remainder = n;
            for(int i = 0 ; i < len-1 ; i++){
                if((solutionIndex&1<<len-2-i) > 0){
                    answer[i] = ryan[i];
                    remainder -= ryan[i];
                } else answer[i] = 0;
            }
            answer[len-1] = remainder;
        }
        return answer;
    }
}
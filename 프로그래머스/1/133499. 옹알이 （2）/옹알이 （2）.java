class Solution {
    public static String[] babblingArray = {"aya", "ye", "woo", "ma"};
    public static String[] doubleBabblings = {"ayaaya", "yeye", "woowoo", "mama"};
  
    public int solution(String[] babbling) {
        int answer = 0;
        for(String bab : babbling) {
            if(!isDoubleBabbling(bab)) {
                for(String str : babblingArray) bab = bab.replaceAll(str, " ");
                if(bab.replaceAll(" ","").equals("")) answer++;
            }
        }

        return answer;
    }
    
    private boolean isDoubleBabbling(String s){
        for(String bab : doubleBabblings) 
            if(s.contains(bab)) return true;
        return false;
    }
}
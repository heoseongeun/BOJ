class Solution {
    static int len;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        len = n;
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            char[] result = new char[n];
            boolean[] b1 = toBinary(arr1[i]);
            boolean[] b2 = toBinary(arr2[i]);
            for(int j = 0; j < n; j++) {
                if(b1[j] || b2[j]) {
                    result[j] = '#';}
                else result[j] = ' ';
            }
            answer[i] = String.valueOf(result);
        }
        return answer;
    }
    
    boolean[] toBinary(int num) {
        boolean[] result = new boolean[len];
        for(int i = 0; i < len; i++) {
            if(num % 2 == 0) result[len - 1 - i] = false;
            else result[len - 1 - i] = true;
            num /= 2;
        }
        return result;
    }
}
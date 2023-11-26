class Solution {
    public int[] solution(String s) {
        int repeat = 0, count = 0;
        while(!s.equals("1")) {
            int n = s.length();
            int cnt = 0;    
            for(int i = 0; i < n; i++) {
                if(s.charAt(i) == '0') continue;
                cnt++;
            }
            repeat++; count += (n - cnt);
            s = "";
            while(cnt > 0) {
                s = (cnt % 2) + s;
                cnt /= 2;
            }       
        }
        return new int[]{repeat, count};
    }
}
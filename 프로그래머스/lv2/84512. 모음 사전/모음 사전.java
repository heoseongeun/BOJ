class Solution {
    char[] arr = {'A', 'E', 'I', 'O', 'U'};
	int num = 0;
	String word;
	boolean isFind = false;
    
    public int solution(String word) {
        this.word = word;
        find(0, "");
        return num;
    }
    
    public void find(int idx, String str) {
    	for (int i = idx; i < 5; i++) {
    		
    		String temp = str + arr[i];
    		int len = temp.length();
    		num++;
    		
        	if(word.equals(temp)) {
    			isFind = true;
    			return;
    		}
        	
        	if(len == 5) continue;
    		
        	find(idx, temp);
        	
    		if(isFind) return;
		}    	
    }
}
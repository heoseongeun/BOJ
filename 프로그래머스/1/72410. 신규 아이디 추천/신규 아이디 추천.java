class Solution {
    public String solution(String new_id) {
        String id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c:id.toCharArray())
            if(check(c)) sb.append(c);
        id = sb.toString();
        
        sb = new StringBuilder();
        for(int i=0; i<id.length(); i++) {
            char c = id.charAt(i);
            if(c == '.' && sb.length() > 0 && sb.charAt(sb.length()-1) == '.')
                continue;
            sb.append(c);
        }
        
        if(sb.length() > 0 && sb.charAt(0) == '.')
            sb.deleteCharAt(0);
        if(sb.length() > 0 && sb.charAt(sb.length()-1) == '.')
            sb.deleteCharAt(sb.length()-1);
        id = sb.toString();
        
        if(id.length() == 0) id = "a";
        
        int last = 15;
        if(id.length() > last){
            if(id.charAt(last-1) == '.') last--;
            id = id.substring(0, last);
        }
        while(id.length() < 3) 
            id += id.charAt(id.length()-1);
        
        return id;
    }
    
    boolean check(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'z' 
            || "-_.".indexOf(c) != -1;
    }
}
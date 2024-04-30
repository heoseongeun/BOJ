class Solution {
    public String solution(String polynomial) {
        int count = 0, num = 0;
    
        for(String s : polynomial.split(" ")) {
            if(s.contains("x"))
                count += s.equals("x") ? 1 : Integer.parseInt(s.replace("x", ""));
            else if(!s.equals("+")) 
                num += Integer.parseInt(s);
        }
        
        return (count != 0 ? count > 1 ? count + "x" : "x" : "") 
        		+ (num != 0 ? (count != 0 ? " + " : "") 
                + num : count == 0 ? "0" : "");
    }
}
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        if(str1.equals(str2)) return 65536;
        String str = "";
        for(int i = 0; i < str1.length() - 1; i++) {
            str = str1.substring(i, i + 2);
            if((str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') &&
                (str.charAt(1) >= 'A' && str.charAt(1) <= 'Z')) list1.add(str);
        }
        for(int i = 0; i < str2.length() - 1; i++) {
            str = str2.substring(i, i + 2);
            if((str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') &&
                (str.charAt(1) >= 'A' && str.charAt(1) <= 'Z')) list2.add(str);
        }
        int union = 0, inter = 0;
        for(String s: list1) {
            if(list2.remove(s)) inter++;
            union++;
        }
        for(String s: list2) union++;
        return (int)((float)inter / union * 65536);
    }
}
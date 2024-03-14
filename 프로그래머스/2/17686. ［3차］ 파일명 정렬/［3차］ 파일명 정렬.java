import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            
        public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0].toLowerCase();
                String head2 = o2.split("[0-9]")[0].toLowerCase();

                if(head1.compareTo(head2) == 0) {
                    return compareNum(o1, head1) - compareNum(o2, head2);
                } else return head1.compareTo(head2);
            }
        });
        return files;
    }
    
    public static int compareNum(String o1, String head1) {
        int len1 = head1.length();
        String num = "";
        for(int i = len1; i < o1.length(); i++) {
            if(Character.isDigit(o1.charAt(i))) {
                num += o1.charAt(i);
            } else 
                break;
        }
        return Integer.parseInt(num);
    }
}
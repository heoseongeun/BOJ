import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] record) {
        int n = record.length;
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < record.length; i++) {
            String s = record[i];
            String[] arr = s.split(" ");
            if(arr[0].equals("Leave")) continue;
            map.put(arr[1], arr[2]);
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++) { 
            String s = record[i];
            String[] arr = s.split(" ");
            if(arr[0].equals("Enter")) {
                list.add(map.get(arr[1]) + "님이 들어왔습니다.");
            } else if(arr[0].equals("Leave")) {
                list.add(map.get(arr[1]) + "님이 나갔습니다.");
            } else continue;
        }
        return list.stream().toArray(array -> new String[list.size()]);
    }
}
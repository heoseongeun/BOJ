import java.util.*;

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = {};
        int len = s.length(), n = 0, idx = 0;
        s = s.substring(2, len -  2);
        String[] arr = s.split("\\},\\{");
        Arrays.sort(arr, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
        for(String str: arr) {
            String[] tmp = str.split(",");
            for(int i = 0; i < tmp.length; i++) {
                int t = Integer.parseInt(tmp[i]);
                if(list.contains(t)) continue;
                list.add(t);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
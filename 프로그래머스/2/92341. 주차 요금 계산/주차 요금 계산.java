import java.util.*;

class Solution {
	public static int[] solution(int[] fees, String[] records) {
		HashMap<String, String> cars = new HashMap<String, String>();	
		HashMap<String, Integer> result = new HashMap<String, Integer>();	
		for (int i = 0; i < records.length; i++) {
			String temp[] = records[i].split(" ");
			if (temp[2].equals("IN")) {
				cars.put(temp[1], temp[0]);
			} else {	
				String timeIn[] = cars.get(temp[1]).split(":");
				cars.remove(temp[1]);
				String timeOut[] = temp[0].split(":");
				int min = 0;	
				min += (Integer.parseInt(timeOut[0]) - Integer.parseInt(timeIn[0])) * 60;
				min += Integer.parseInt(timeOut[1]) - Integer.parseInt(timeIn[1]);
				if (result.containsKey(temp[1])) {	
					result.replace(temp[1], result.get(temp[1]) + min);
				} else {
					result.put(temp[1], min);
				}
			}
		}
		for (String s : cars.keySet()) {	
			String[] timeIn = cars.get(s).split(":");
			int min = 0;
			min += (23 - Integer.parseInt(timeIn[0])) * 60;
			min += 59 - Integer.parseInt(timeIn[1]);
			if (result.containsKey(s)) {
				result.replace(s, result.get(s) + min);
			} else {
				result.put(s, min);
			}
		}
		Object[] sortKey = result.keySet().toArray();
		Arrays.sort(sortKey);
		int[] answer = new int[sortKey.length];
		for (int i = 0; i < sortKey.length; i++) {
			int totalMin = result.get(sortKey[i]);
			int fee = 0;
			if (totalMin >= fees[0]) {	
				totalMin -= fees[0];
				fee = fees[1];
			} else {
				totalMin = 0;
				fee = fees[1];
			}
			if (totalMin > 0) {	
				if (totalMin % fees[2] == 0) {
					fee += totalMin / fees[2] * fees[3];
				} else {
					fee += (totalMin / fees[2] + 1) * fees[3];
				}
			}
			answer[i] = fee;
		}
		return answer;
	}
}
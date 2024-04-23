class Solution {
    public String[] solution(String[] quiz) {
        int n = quiz.length;
        String[] answer = new String[n];
		for(int i = 0; i < n; i++) {
			String arr[] = quiz[i].split(" ");
			int left = arr[1].equals("+") ? Integer.parseInt(arr[0]) + Integer.parseInt(arr[2])
					: Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]);
			int right = Integer.parseInt(arr[4]);
			answer[i] = left == right ? "O" : "X";
		}
        return answer;
    }
}
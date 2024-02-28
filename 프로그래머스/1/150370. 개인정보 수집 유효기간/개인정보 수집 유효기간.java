import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, dtf);
        HashMap<Character, Integer> map = new HashMap<>();
        for(String term: terms) {
            String[] ts =  term.split(" ");
            map.put(ts[0].charAt(0), Integer.parseInt(ts[1]));
        }
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            LocalDate privacyDate = LocalDate.parse(privacy[0], dtf)
                .plusMonths(map.get(privacy[1].charAt(0))).minusDays(1);
            if(privacyDate.isBefore(todayDate)) answer.add(i + 1);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
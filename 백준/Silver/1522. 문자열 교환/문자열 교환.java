import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int min = Integer.MAX_VALUE, a = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'a') a++;
		}
		for(int i = 0; i < str.length(); i++) {
			int b = 0;
			for(int j = i; j < i + a; j++) {
				int idx = j % str.length();
				if(str.charAt(idx) == 'b') b++;
			}
			min = Math.min(min, b);
		}
		System.out.println(min);
	}
}
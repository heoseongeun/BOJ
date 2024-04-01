class Solution {
    public long solution(int w, int h) {
		long ref = gcd(w, h);
		return ((long) w * h) - (((w / ref) + (h / ref) - 1) * ref);
	}
    
    private int gcd(int n, int m) {
        if(m == 0) return n;
        return gcd(m, n % m);
	}
}
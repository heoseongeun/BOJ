class Solution {
    public int[] solution(int n, int m) {
        return new int[]{gcd(n, m), lcm(n, m)};
    }
    
    public int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
    
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}